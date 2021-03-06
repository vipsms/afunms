package com.afunms.system.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.afunms.system.dao.TimeShareConfigDao;
import com.afunms.system.model.TimeShareConfig;

@SuppressWarnings("unchecked")
public class TimeShareConfigUtil {
	/**
	 * 
	 * @param objectId
	 * @param objectType
	 * @return
	 */
	public boolean deleteTimeShareConfig(String objectId, String objectType) {
		if (objectId == null || "".equals(objectId)) {
			throw new NullPointerException("objectId is null");
		}
		if (objectType == null || "".equals(objectType)) {
			throw new NullPointerException("objectType is null");
		}
		boolean result = false;
		TimeShareConfigDao dao = new TimeShareConfigDao();
		try {
			result = dao.deleteTimeShareConfigListByObject(objectId, objectType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return result;
	}

	public String getObjectType(String type) {
		if (type == null) {
			throw new NullPointerException("type is null");
		}
		if ("0".equals(type)) {
			return "equipment";
		} else if ("1".equals(type)) {
			return "db";
		} else if ("2".equals(type)) {
			return "ftpservice";
		} else if ("3".equals(type)) {
			return "emailservice";
		} else if ("4".equals(type)) {
			return "webservice";
		} else if ("5".equals(type)) {
			return "grapesservice";
		} else if ("6".equals(type)) {
			return "radarservice";
		} else if ("7".equals(type)) {
			return "plotservice";
		} else if ("8".equals(type)) {
			return "portservice";
		} else if ("9".equals(type)) {
			return "mq";
		} else if ("10".equals(type)) {
			return "domino";
		}
		if ("11".equals(type)) {
			return "was";
		} else if ("12".equals(type)) {
			return "weblogic";
		} else if ("13".equals(type)) {
			return "tomcat";
		} else if ("14".equals(type)) {
			return "iis";
		} else if ("15".equals(type)) {
			return "temperaturehumidity";
		} else if ("16".equals(type)) {
			return "tuexdo";
		} else if ("17".equals(type)) {
			return "storage";
		} else if ("18".equals(type)) {
			return "tftpservice";
		} else if ("19".equals(type)) {
			return "resin";
		} else if ("20".equals(type)) {
			return "dpservice";
		} else if ("21".equals(type)) {
			return "nasservice";
		} else if ("22".equals(type)) {
			return "ggsciservice";
		} else if ("23".equals(type)) {
			return "ntpservice";
		}
		return null;
	}

	public List getTimeShareConfigList(String objectId, String objectType) {
		if (objectId == null || "".equals(objectId)) {
			throw new NullPointerException("objectId is null");
		}
		if (objectType == null || "".equals(objectType)) {
			throw new NullPointerException("objectType is null");
		}
		List timeShareConfigList = new ArrayList();
		TimeShareConfigDao dao = new TimeShareConfigDao();
		try {
			timeShareConfigList = dao.getTimeShareConfigByObject(objectId, objectType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return timeShareConfigList;
	}

	public boolean saveTimeShareConfigList(HttpServletRequest request, String objectId, String objectType) {
		if (request == null) {
			throw new NullPointerException("request is null");
		}
		if (objectId == null || "".equals(objectId)) {
			throw new NullPointerException("objectId is null");
		}
		if (objectType == null || "".equals(objectType)) {
			throw new NullPointerException("objectType is null");
		}
		boolean result = false;
		List<TimeShareConfig> timeShareConfigList = new ArrayList<TimeShareConfig>();
		int num = 0;
		try {
			num = Integer.parseInt(request.getParameter("rowNum"));
		} catch (Exception e) {
			return result;
		}
		for (int i = 1; i <= num; i++) {
			String partName = "";
			if (i < 10) {
				partName = "0" + String.valueOf(i);
			} else {
				partName = String.valueOf(i);
			}
			String beginTime = request.getParameter("beginTime" + partName);
			String endTime = request.getParameter("endTime" + partName);
			String userIds = request.getParameter("userIds" + partName);
			String timeShareType = request.getParameter("timeShareType" + partName);
			if ((userIds != null) && (!userIds.equals(""))) {
				TimeShareConfig timeShareConfig = new TimeShareConfig();
				timeShareConfig.setObjectId(objectId);
				timeShareConfig.setObjectType(objectType);
				timeShareConfig.setTimeShareType(timeShareType);
				timeShareConfig.setBeginTime(beginTime);
				timeShareConfig.setEndTime(endTime);
				timeShareConfig.setUserIds(userIds);
				timeShareConfigList.add(timeShareConfig);
			}
		}
		TimeShareConfigDao dao = new TimeShareConfigDao();
		try {
			result = dao.saveTimeShareConfigList(objectId, objectType, timeShareConfigList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return result;
	}
}
