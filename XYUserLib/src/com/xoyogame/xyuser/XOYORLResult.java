/*
 * 用户注册、登录返回值结构
 * 
 * **/
package com.xoyogame.xyuser;

import org.json.JSONException;
import org.json.JSONObject;

import com.xoyogame.conf.Conf;

public final class XOYORLResult extends XOYORetResult {

	@Override
	public Boolean restoreFromString(String str) {
		try {
			JSONObject obj = new JSONObject(str);
			this.setRetCode(obj.getInt(Conf.RETURN_KEY_RETCODE));
			this.setRetMsg(obj.getString(Conf.RETURN_KEY_RETMSG));

			if (obj.has(Conf.RETURN_KEY_RETINFO)) {
				JSONObject objInfo = obj.getJSONObject(Conf.RETURN_KEY_RETINFO);
				this.info_ = new Info();

				this.info_.uid_ = objInfo
						.getString(Conf.RETURN_KEY_RETINFO_ACCOUNTNAME);
				this.info_.accountName_ = objInfo
						.getString(Conf.RETURN_KEY_RETINFO_UID);
			}

			return true;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public class Info {
		private String uid_ = null;

		public String getUid() {
			return uid_;
		}

		private String accountName_ = null;

		public String getAccount() {
			return accountName_;
		}

	}

	private Info info_ = null;

	public Info getInfo() {
		return info_;
	}
}