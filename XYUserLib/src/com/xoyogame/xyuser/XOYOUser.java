package com.xoyogame.xyuser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

import com.xoyogame.conf.Conf;
import com.xoyogame.net.HTTPRequest;
import com.xoyogame.utils.Utils;


public class XOYOUser {

	protected static Boolean checkInputForRegister(String userName,
			String password, String password2, XOYORLResult retResult) {

		if (Utils.stringIsNullOrEmpty(userName)
				|| Utils.stringIsNullOrEmpty(password)) {

			retResult
					.setRetCode(Conf.RETURN_CODE_REGISTER_PARAMS_CANNOT_BE_EMPTY);
			retResult.setRetMsg(Conf.MSG_ERROR_PARAM_CANNOT_BE_EMPTY);
			return false;
		}

		if (!password.equals(password2)) {

			retResult.setRetCode(Conf.RETURN_CODE_REGISTER_PWD_DONT_MATCH);
			retResult
					.setRetMsg(Conf.MSG_ERROR_REGISTER_TWO_PASSWORD_DONOT_MATCH);
			return false;
		}

		return true;
	}

	public static XOYORLResult register(String userName, String password,
			String password2) throws ClientProtocolException, IOException {
		XOYORLResult retResult = new XOYORLResult();

		if (checkInputForRegister(userName, password, password2, retResult)) {

			Map<String, String> params = new HashMap<String, String>();
			params.put(Conf.PARAM_ACT, Conf.ACT_REGISTER);
			params.put(Conf.PARAM_USERNAME, userName);
			params.put(Conf.PARAM_PASSWORD, password);
			params.put(Conf.PARAM_PASSWORD2, password2);
			params.put(Conf.PARAM_CHECKSUM,
					Utils.getMD5String(userName + Conf.CHECKSUMSALT));

			retResult.restoreFromString(HTTPRequest.sendPostRequest(Conf.HOST,
					params));
		}

		return retResult;
	}

	protected static Boolean checkInputForLogin(String userName,
			String password, XOYORLResult retResult) {

		if (Utils.stringIsNullOrEmpty(userName)
				|| Utils.stringIsNullOrEmpty(password)) {

			retResult
					.setRetCode(Conf.RETURN_CODE_REGISTER_PARAMS_CANNOT_BE_EMPTY);
			retResult.setRetMsg(Conf.MSG_ERROR_PARAM_CANNOT_BE_EMPTY);
			return false;
		}

		return true;
	}

	public static XOYORLResult login(String userName, String password)
			throws ClientProtocolException, IOException {
		XOYORLResult retResult = new XOYORLResult();

		if (checkInputForLogin(userName, password, retResult)) {

			Map<String, String> params = new HashMap<String, String>();
			params.put(Conf.PARAM_ACT, Conf.ACT_LOGIN);
			params.put(Conf.PARAM_USERNAME, userName);
			params.put(Conf.PARAM_PASSWORD, password);
			params.put(Conf.PARAM_CHECKSUM,
					Utils.getMD5String(userName + Conf.CHECKSUMSALT));

			retResult.restoreFromString(HTTPRequest.sendPostRequest(Conf.HOST,
					params));
		}

		return retResult;
	}

	public static XOYOChargeResult charge(String uid, String snNo, String snPwd)
			throws Exception {
		throw new Exception("function charge doesn't implement");
	}

}