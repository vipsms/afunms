package com.afunms.common.util;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;
import java.util.Queue;

import com.afunms.initialize.ResourceCenter;
import com.afunms.util.DataGate;

@SuppressWarnings("unchecked")
public class DBManager {
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	protected String preparesql;

	public DBManager() {
		try {
			init(ResourceCenter.getInstance().getJndi());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DBManager(String jndi) throws Exception {
		init(jndi);
	}

	/**
	 * 加入批处理
	 */
	public void addBatch(String sql) {
		try {
			stmt.addBatch(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 加入批处理
	 */

	public void addPrepareBatch(List list) {
		try {
			pstmt.setString(1, (String) list.get(0));
			pstmt.setString(2, (String) list.get(1));
			pstmt.setString(3, (String) list.get(2));
			pstmt.setString(4, (String) list.get(3));
			pstmt.setString(5, (String) list.get(4));
			pstmt.setString(6, (String) list.get(5));
			pstmt.setString(7, (String) list.get(6));
			pstmt.setString(8, (String) list.get(7));
			pstmt.setString(9, (String) list.get(8));
			pstmt.setString(10, (String) list.get(9));
			if ("mysql".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setString(11, (String) list.get(10));
			} else if ("oracle".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setTimestamp(11, Timestamp.valueOf((String) list.get(10)));
			}

			pstmt.setString(12, (String) list.get(11));
			pstmt.setString(13, (String) list.get(12));
			pstmt.addBatch();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 加入批处理
	 */
	public void addPrepareErrptBatch(List list) {
		try {
			pstmt.setString(1, (String) list.get(0));
			pstmt.setString(2, (String) list.get(1));

			if ("mysql".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setString(3, (String) list.get(2));
			} else if ("oracle".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setTimestamp(3, Timestamp.valueOf((String) list.get(2)));
			}
			pstmt.setInt(4, (Integer) list.get(3));
			pstmt.setString(5, (String) list.get(4));
			pstmt.setString(6, (String) list.get(5));
			pstmt.setString(7, (String) list.get(6));
			pstmt.setString(8, (String) list.get(7));
			pstmt.setString(9, (String) list.get(8));
			pstmt.setString(10, (String) list.get(9));
			pstmt.setString(11, (String) list.get(10));
			pstmt.setString(12, (String) list.get(11));
			pstmt.setString(13, (String) list.get(12));
			pstmt.setString(14, (String) list.get(13));
			pstmt.setString(15, (String) list.get(14));
			pstmt.addBatch();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 加入批处理
	 */
	public void addPrepareProcBatch(List list) {
		try {
			pstmt.setString(1, (String) list.get(0));
			pstmt.setString(2, (String) list.get(1));
			pstmt.setString(3, (String) list.get(2));
			pstmt.setString(4, (String) list.get(3));
			pstmt.setString(5, (String) list.get(4));
			pstmt.setString(6, (String) list.get(5));
			pstmt.setString(7, (String) list.get(6));
			pstmt.setString(8, (String) list.get(7));
			pstmt.setString(9, (String) list.get(8));
			pstmt.setString(10, (String) list.get(9));

			if ("mysql".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setString(11, (String) list.get(10));
			} else if ("oracle".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setTimestamp(11, Timestamp.valueOf((String) list.get(10)));
			}
			pstmt.addBatch();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 加入批处理
	 */
	public void addPrepareProcLongBatch(List list) {
		try {
			pstmt.setString(1, (String) list.get(0));
			pstmt.setString(2, (String) list.get(1));
			pstmt.setString(3, (String) list.get(2));
			pstmt.setString(4, (String) list.get(3));
			pstmt.setString(5, (String) list.get(4));
			pstmt.setString(6, (String) list.get(5));
			pstmt.setString(7, (String) list.get(6));
			pstmt.setString(8, (String) list.get(7));
			pstmt.setLong(9, (Long) list.get(8));
			pstmt.setString(10, (String) list.get(9));
			if ("mysql".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setString(11, (String) list.get(10));
			} else if ("oracle".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setTimestamp(11, Timestamp.valueOf((String) list.get(10)));
			}

			pstmt.addBatch();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 加入批处理
	 */
	public void addPrepareServiceBatch(List list) {
		try {
			pstmt.setString(1, (String) list.get(0));
			pstmt.setString(2, (String) list.get(1));
			pstmt.setString(3, (String) list.get(2));
			pstmt.setString(4, (String) list.get(3));
			pstmt.setString(5, (String) list.get(4));
			pstmt.setString(6, (String) list.get(5));
			pstmt.setString(7, (String) list.get(6));
			pstmt.setString(8, (String) list.get(7));
			pstmt.setString(9, (String) list.get(8));

			if ("mysql".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setString(10, (String) list.get(9));
			} else if ("oracle".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setTimestamp(10, Timestamp.valueOf((String) list.get(9)));
			}
			pstmt.addBatch();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 加入批处理
	 */
	public void addPrepareSoftwareBatch(List list) {
		try {
			pstmt.setString(1, (String) list.get(0));
			pstmt.setString(2, (String) list.get(1));
			pstmt.setString(3, (String) list.get(2));
			pstmt.setString(4, (String) list.get(3));
			pstmt.setString(5, (String) list.get(4));
			pstmt.setString(6, (String) list.get(5));
			pstmt.setString(7, (String) list.get(6));
			pstmt.setString(8, (String) list.get(7));

			if ("mysql".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setString(9, (String) list.get(8));
			} else if ("oracle".equalsIgnoreCase(SystemConstant.DBType)) {
				pstmt.setTimestamp(9, Timestamp.valueOf((String) list.get(8)));
			}
			pstmt.addBatch();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 关闭连接
	 */
	public void close() {

		try {
			conn.commit();
			DataGate.freeCon(conn);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 提交
	 */
	public void commit() {
		try {
			conn.commit();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 
	 * @author konglq
	 * @date 2010-8-26 下午12:43:40
	 * @param list
	 *            list中每个节点是一条sql语句
	 * @return boolean
	 * @Description: TODO批量执行更新类sql语句(insert delete update)
	 */
	public boolean excuteBatchSql(List<String> list) {
		if (list == null) {
			return false;
		}
		try {
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					addBatch(list.get(i));
				}
				int[] iResult = null;
				iResult = executeBatchs();
				if (iResult != null) {
					String str = iResult.toString();
					if (str.indexOf(-1) >= 0) {
						return false;
					}
				} else {
					return false;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @author konglq
	 * @date 2010-8-26 下午12:43:40
	 * @param list
	 *            list中每个节点是一条sql语句
	 * @return boolean
	 * @Description: TODO批量执行更新类sql语句(insert delete update)
	 */
	public boolean excuteBatchSql(Queue<String> list) {
		if (list == null) {
			return false;
		}
		try {
			if (null == conn) {
				conn = DataGate.getCon();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
			}
			conn.setAutoCommit(false);
			if (list.size() > 0) {
				String sql = "";
				while ((sql = list.poll()) != null) {
					stmt.addBatch(sql);
				}
				stmt.executeBatch();
				conn.commit();
				DataGate.freeCon(conn);// 先释放连接，后关闭游标
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.commit();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 执行批处理
	 */
	public void executeBatch() {
		try {
			stmt.executeBatch();
			conn.commit();
		} catch (BatchUpdateException bse) {
			bse.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			try {
				stmt.clearBatch();
			} catch (SQLException xe) {
				xe.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @author konglq
	 * @创建时间 2010-8-24 上午01:01:44
	 * @方法名 executeBatch
	 * @return int[]
	 * @功能如下 执行批处理
	 */
	public int[] executeBatchs() {
		int[] intlist = null;
		try {
			if (null == conn) {
				conn = DataGate.getCon();
				conn.setAutoCommit(false);
				stmt = conn.createStatement();
			}
			conn.setAutoCommit(false);
			intlist = stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);

		} catch (BatchUpdateException bse) {
			bse.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}  finally {
			try {
				stmt.clearBatch();
				stmt.close();
				conn.setAutoCommit(true);
			} catch (SQLException xe) {
				xe.printStackTrace();
			}
		}
		return intlist;
	}

	/**
	 * 执行批处理
	 */
	public void executePreparedBatch() {
		try {
			pstmt.executeBatch();
			conn.commit();
		} catch (BatchUpdateException bse) {
			bse.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		} finally {
			try {
				pstmt.clearBatch();
			} catch (SQLException xe) {
			}
		}
	}

	/**
	 * 查询
	 */
	public ResultSet executeQuery(String sql) {
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return rs;
	}

	/**
	 * 根据sql 统计查询数据记录的总数， sql 中必须有count(*) 如果没有则直接返回0
	 * 
	 * @方法名 executeQuery
	 * @param sql
	 * @return ResultSet
	 * @功能如下 执行查询，返回ResultSet
	 */
	public int executeQueryCount(String sql) {
		int i = 0;

		if (sql.indexOf("count(*)") > 0) {// 如果sql 中没有count(*) 则不做统计
			try {
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					i = rs.getInt(1);
				}

			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return i;
	}

	/**
	 * 一次只从数据库中查询最大maxCount条记录
	 * 
	 * @param sql
	 *            传入的sql语句
	 * @param startNo
	 *            从哪一条记录开始
	 * @param maxCount
	 *            总共取多少条记录
	 */
	public ResultSet executeQueryFromAll(String sql, int startNo, int maxCount) {
		ResultSet rs = null;
		try {
			PreparedStatement pstat = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// 最大查询到第几条记录
			pstat.setMaxRows(startNo + maxCount - 1);
			rs = pstat.executeQuery();
			// 将游标移动到第一条记录
			rs.first();
			// 游标移动到要输出的第一条记录
			rs.relative(startNo - 2);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 
	 * @author konglq
	 * @创建时间 2010-8-24 上午12:58:26
	 * @方法名 executeQueryListHashMap
	 * @param sql
	 * @param indexkey
	 *            代表一条记录的唯一key
	 * @return
	 * @throws SQLException
	 *             List
	 * @功能如下 执行数据库查询语句返回向量类型的数据,向量的每一个值是哈希表 每个哈希表代表一条记录
	 */
	public Hashtable executeQuerykeyoneListHashMap(String sql, String indexkey) throws SQLException {
		ResultSetMetaData rsmd = null;
		Hashtable list = new Hashtable();
		int columnCount = 0;
		try {
			rs = executeQuery(sql);
			if (rs == null) {
				return null;
			}
			rsmd = rs.getMetaData();
			if (rsmd == null) {
				return null;
			}
			columnCount = rsmd.getColumnCount(); // 得到字段数量
			if (columnCount == 0) {
				return null;
			}

			// 向量的第一个值是列名集合
			String[] keys = new String[columnCount];
			for (int i = 1; i <= columnCount; i++) {
				keys[i - 1] = rsmd.getColumnName(i); // 获得字段名
			}
			while (rs.next()) {
				Hashtable hm = new Hashtable();
				hm.clear();
				String key = null;
				for (int i = 1; i <= columnCount; i++) {
					String result = rs.getString(i);
					if ((result == null) || (result.length() == 0)) {
						result = "";
					}

					if (keys[i - 1].equals(indexkey)) {
						key = result;
					}

					hm.put(keys[i - 1], result); // 将每条记录保存到一个哈希表中，key为字段名，result为值
				}
				list.put(key, hm); // 将数据集的每一行插入向量
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list; // 返回SQL语言的查询结果集。
	}

	/**
	 * 更新,并提交
	 */
	public void executeUpdate(String sql) {
		executeUpdate(sql, true);
	}

	/**
	 * 更新
	 */
	public void executeUpdate(String sql, boolean bCommit) {
		try {
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (bCommit) {
				conn.commit();
			}
		} catch (SQLException se) {
			se.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	/**
	 * 我们默认系统数据库是可以正常连接的，所以不抛出错误
	 */

	public Connection getConn() {
		return conn;
	}

	/**
	 * 初始化
	 */
	public void init(String jndi) {
		try {
			conn = DataGate.getCon();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

	/**
	 * 回滚
	 */
	public void rollback() {
		try {
			conn.rollback();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * 设置批处理SQL
	 */
	public void setPrepareSql(String sql) {
		preparesql = sql;
		try {
			pstmt = conn.prepareStatement(preparesql);
		} catch (SQLException xe) {
			xe.printStackTrace();
		}
	}
}
