/*
 * 接口返回结果基类
 * 
 * 
 */
package com.xoyogame.xyuser;

public abstract class XOYORetResult {

	public abstract Boolean restoreFromString(String str);

	/*
	 * 返回代码
	 */
	private int retCode_ = 0;

	public int getRetCode() {
		return retCode_;
	}

	protected void setRetCode(final int value) {
		retCode_ = value;
	}

	/*
	 * 返回消息
	 */
	private String retMsg_ = null;

	public String getRetMsg() {
		return retMsg_;
	}

	protected void setRetMsg(String value) {
		retMsg_ = value;
	}
}
