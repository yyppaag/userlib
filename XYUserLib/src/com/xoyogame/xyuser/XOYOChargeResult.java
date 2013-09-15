/*
 * 用户充值 返回结果 
 *  
 *  
 *  
 */
package com.xoyogame.xyuser;

import org.json.JSONException;
import org.json.JSONObject;

import com.xoyogame.conf.Conf;

public final class XOYOChargeResult extends XOYORetResult {

	@Override
	public Boolean restoreFromString(String str) {
		try {
			JSONObject obj = new JSONObject(str);
			this.setRetCode(obj.getInt(Conf.RETURN_KEY_RETCODE));
			this.setRetMsg(obj.getString(Conf.RETURN_KEY_RETMSG));
			
			if (obj.has(Conf.RETURN_KEY_RETINFO)) {
				JSONObject objInfo = obj.getJSONObject(Conf.RETURN_KEY_RETINFO);

				this.info_ = new Info();

				this.info_.coins_ = objInfo
						.getDouble(Conf.RETURN_KEY_RETINFO_COINS);
				this.info_.platform_coins_ = objInfo
						.getDouble(Conf.RETURN_KEY_RETINFO_PLATFORM_COINS);
			}

			return true;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public class Info {

		private double coins_ = 0.0;

		public double getCoins() {
			return coins_;
		}

		private double platform_coins_ = 0.0;

		public double getPlatformCoins() {
			return platform_coins_;
		}
	}

	private Info info_ = null;

	public Info getInfo() {
		return info_;
	}
}
