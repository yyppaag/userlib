package com.xoyogame.conf;


public class Conf {
	public static final String Version = "0.0.0.1";
	
	public static final String HOST = "http://10.0.2.2:42557/Default.aspx";
	public static final String CHECKSUMSALT = "xoyogame.user.0.0.1";
	
	/*
	 * 参数
	*/
	public static final String PARAM_ACT = "act";
	public static final String PARAM_USERNAME = "username";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_PASSWORD2 = "password2";
	public static final String PARAM_CHECKSUM = "chksum";

	
	/*
	 * 参数 act 类型
	*/
	public static final String ACT_REGISTER = "User.register";
	public static final String ACT_LOGIN = "User.login";
	public static final String ACT_CHARGE = "User.charge";
	
	/*
	 * 返回值 key
	*/
	
	public static final String RETURN_KEY_RETCODE = "retcode";
	public static final String RETURN_KEY_RETMSG = "retmsg";
	public static final String RETURN_KEY_RETINFO = "info";
	
	public static final String RETURN_KEY_RETINFO_UID = "uid";
	public static final String RETURN_KEY_RETINFO_ACCOUNTNAME = "s_Account";
	
	// both below unconfirmed
	public static final String RETURN_KEY_RETINFO_COINS = "coins";
	public static final String RETURN_KEY_RETINFO_PLATFORM_COINS = "platformCoins";
	
	
	/*
	 * error msg 
	 *
	 *
	*/
	public static final String MSG_SUCCESS = "SUCCESS";
	public static final String MSG_ERROR_PARAM_CANNOT_BE_EMPTY = "参数不能为空";
	public static final String MSG_ERROR_REGISTER_USERNAME_OR_PASSWORD_WRONG = "用户名或密码不正确";
	public static final String MSG_ERROR_REGISTER_TWO_PASSWORD_DONOT_MATCH = "两次输入密码不一致";

	public static final String MSG_ERROR_lOGIN_USERNAME_OR_PASSWORD_WRONG = "用户名或密码不正确";
		
	/*
	 * return code 
	 *
	 *
	*/
	public static final int RETURN_CODE_SUCCESS = 0;
	
	public static final int RETURN_CODE_REGISTER_PARAMS_CANNOT_BE_EMPTY = 1;
	public static final int RETURN_CODE_REGISTER_PWD_DONT_MATCH = 2;
	public static final int RETURN_CODE_REGISTER_EXISTED = 3;
	
	public static final int RETURN_CODE_LOGIN_PARAMS_CANNOT_BE_EMPTY = 1;
	public static final int RETURN_CODE_LOGIN_ACCOUNT_DOESNOT_EXIST = 2;
	public static final int RETURN_CODE_LOGIN_PASSWORD_WRONG = 3;
}
