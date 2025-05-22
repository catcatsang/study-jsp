package com.app.repository.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.configuration.Configuration;
import com.app.domain.vo.MemberVO;
import com.app.domain.vo.PostVO;

public class PostDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

//   추가하기
	public void insert(PostVO postVO) {
		String query = "INSERT INTO TBL_POST " + "(ID, POST_TITLE, POST_CONTENT, POST_READ_COUNT, MEMBER_ID) "
				+ "VALUES(SEQ_POST.NEXTVAL, ?, ?, ?, ?)";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, postVO.getPostTitle());
			preparedStatement.setString(2, postVO.getPostContent());
			preparedStatement.setInt(3, postVO.getPostReadCount());
			preparedStatement.setLong(4, postVO.getMemberId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}

//   조회하기
	public Optional<PostVO> selectById(Long id) {
		PostVO post = null;
		String query = "SELECT ID, POST_TITLE, POST_CONTENT, POST_READ_COUNT, "
				+ "MEMBER_ID, CREATED_DATE, UPDATED_DATE " + "FROM TBL_POST " + "WHERE ID = ? ";

		connection = Configuration.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				post = new PostVO();

				post.setId(resultSet.getLong(1));
				post.setPostTitle(resultSet.getString(2));
				post.setPostContent(resultSet.getString(3));
				post.setPostReadCount(resultSet.getInt(4));
				post.setCreatedDate(resultSet.getString(5));
				post.setUpdatedDate(resultSet.getString(6));
				post.setMemberId(resultSet.getLong(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}

		return Optional.ofNullable(post);
	}

//   수정하기
	public void update(PostVO postVO) {
		String query = "UPDATE TBL_POST "
				+ "SET POST_TITLE=?, POST_CONTENT=?, POST_READ_COUNT=?, MEMBER_ID=?, UPDATED_DATE=SYSDATE"
				+ "WHERE ID=?";

		connection = Configuration.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, postVO.getPostTitle());
			preparedStatement.setString(2, postVO.getPostContent());
			preparedStatement.setLong(3, postVO.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}

	}

//   삭제하기
	public void delete(Long id) {
		String query = "DELETE FROM TBL_POST " + "WHERE ID=?";

		connection = Configuration.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}

		}
	}

//   유저정보 조회하기
	public List<PostVO> selectAll(Long memberId) {
		PostVO post = new PostVO();
		List<PostVO> postList = new ArrayList<PostVO>();

		String query = "SELECT ID, POST_TITLE, POST_CONTENT, POST_READ_COUNT, MEMBER_ID, CREATED_DATE, UPDATED_DATE "
				+ "FROM TBL_POST "
				+ "WHERE MEMBER_ID = ?";

		connection = Configuration.getConnection();

		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setLong(1, memberId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				post = new PostVO();

				post.setId(resultSet.getLong(1));
				post.setPostTitle(resultSet.getString(2));
				post.setPostContent(resultSet.getString(3));
				post.setPostReadCount(resultSet.getInt(4));
				post.setMemberId(resultSet.getLong(5));
				post.setCreatedDate(resultSet.getString(6));
				post.setUpdatedDate(resultSet.getString(7));

				postList.add(post);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			}

		}
		return postList;
	}

// 	

//   이메일로 정보 조회

}
