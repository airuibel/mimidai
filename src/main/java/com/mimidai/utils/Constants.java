package com.mimidai.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class Constants {
	public static final String PROJECT_NAME = ResourceBundle.getBundle(
			"application").getString("project_name");

	/**

	 * 资源文件.

	 */
	public static final String KEY = "application-" + PROJECT_NAME;
	/**

	 * 资源绑定对象

	 */
	public static final ResourceBundle RES = ResourceBundle.getBundle(KEY);

	/**

	 * 是否测试环境

	 */
	public static boolean isDevelop = StringUtils.isBlank(RES
			.getString("is_develop")) ? false : Boolean.parseBoolean(RES
			.getString("is_develop"));

	public static final String LOGO_URL = RES.getString("logo_url");

	/**

	 * 公司名称

	 */
	public static final String COMPANY_NAME = RES.getString("company_name");
	/**

	 * 项目名称

	 */
	public static final String SYSTEM_NAME = RES.getString("system_name");

	/**

	 * 真信接口appId

	 */
	public static String CLIENT_APP_ID = RES.getString("client_app_id");
	/**

	 * 真信接口secret

	 */
	public static String CLIENT_APP_SECRET = RES.getString("client_app_secret");
	/**

	 * MMD

	 */
	public static final String BAIDU_API_KEY = RES.getString("baidu_api_key");
	public static final String BAIDU_SECRET_KEY = RES
			.getString("baidu_secret_key");
	/**

	 * @Fields API_KEY : 云片的apikey

	 */
	public static final String YUNPIAN_API_KEY = RES
			.getString("yunpian_api_key");

	public static final String KUAIQIAN_KEY = RES.getString("kuaiqian_key");
	public static final String KUAIQIAN_MERCHANT_ID = RES
			.getString("kuaiqian_merchant_id");
	public static final String KUAIQIAN_MERCHANT_IP = RES
			.getString("kuaiqian_merchant_ip");

	// 向安融共享数据比例

	public static final double MSP_SHARE_PERCENT = Double.parseDouble(RES
			.getString("msp_share_percent")) / 100;

	/**

	 * DMD

	 */
	// public static final String BAIDU_API_KEY = "iPxYOgGktlvp6Fk7YBzuh2Kn";

	// public static final String BAIDU_SECRET_KEY =

	// "qQqVtVTNweF9UWihTqguSlqKIve9viDc";


	// 默认的短信平台

	public static final String DEFAULT_SMS_PLATFORM = RES
			.getString("default_sms_platform");

	// 默认的催收短信发送平台

	public static final String DEFAULT_COLL_SMS_PLATFORM = RES
			.getString("default_coll_sms_platform");
	
	// 默认的联系人催收短信发送平台

    public static final String DEFAULT_CONTEXT_SMS_PLATFORM = RES
            .getString("default_context_sms_platform");
	public static final String DEFAULT_SUCCESS_CODE = "0";
	public static final String DEFAULT_ERROR_CODE = "1";

	public static final String DEFAULT_TO_LOGIN_CODE = "9";

	/**

	 * 应还款状态

	 */
	public static final String BEFORE_REPAYMENT = "0";
	/**

	 * 已还款状态

	 */
	public static final String AFTER_REPAYMENT = "1";

	/**

	 * @Fields STATE_VALID : 有效状态

	 */
	public static final String STATE_VALID = "1";
	/**

	 * @Fields STATE_INVALID : 无效状态

	 */
	public static final String STATE_INVALID = "0";

	/**

	 * 登陆状态，用于登陆日志记录，1-成功登陆，2-登陆失败，非法IP

	 */
	public static final String LOGIN_STATE_SUCCESS = "1";
	public static final String LOGIN_STATE_FAILE = "2";

	/**

	 * @Fields URGENT_VALID : 加急状态

	 */
	public static final String URGENT_VALID = "1";
	/**

	 * @Fields URGENT_INVALID : 非加急状态

	 */
	public static final String URGENT_INVALID = "0";

	// 用户审核状态 用于 user_check表 state 字段


	/**

	 * @Fields STATE_VALID : 未审核状态

	 */
	public static final String USER_AUDIT_STATE_NO = "0";
	/**

	 * @Fields STATE_INVALID : 审核未通过状态

	 */
	public static final String USER_AUDIT_STATE_FAILED = "1";
	/**

	 * @Fields STATE_INVALID : 审核通过状态

	 */
	public static final String USER_AUDIT_STATE_SUCCESS = "2";

	/**

	 * 借款申请申请流程状态 对应loan_apply表中 state 字段

	 */
	// 审核提交申请 综合评估进行中

	public static final String LOAN_APPLY_DISTRIBUTE = "0";
	// 用户取消审核

	public static final String LOAN_APPLY_CANCEL = "1";
	// 已分发 等待综合评估

	public static final String LOAN_AUDIT_WAITING = "2";
	// 综合评估通过 审核确认进行中

	public static final String LOAN_AUDIT_SUCCESS = "3";
	// 综合评估失败拒绝 结束 需要重新发起借款

	public static final String LOAN_AUDIT_FAIL = "4";
	// 综合评估失败取消 结束 需要重新发起借款

	public static final String LOAN_AUDIT_CANCEL = "5";
	// 审核确认通过 等待财务专员审核

	public static final String LOAN_AUDIT_CONFIRM_SUCCESS = "6";
	// 审核确认不通过 返回池子 名字标红

	public static final String LOAN_AUDIT_CONFIRM_FAIL = "7";
	// 财务专员审核通过 等待财务主管放款

	public static final String LOAN_FINANCE_AUDIT_SUCCESS = "8";
	// 财务专员审核不通过 返回池子 名字没变化

	public static final String LOAN_FINANCE_AUDIT_FAIL = "9";
	// 已经发放借款资金 已经完结

	public static final String LOAN_GRANT_FUNDS_SUCCESS = "10";
	// 本单借款结束

	public static final String LOAN_FINISH = "11";

	// 对应user表中 audit_state 字段 身份审核页面

	/**

	 * 刚刚注册

	 */
	public static final String USER_STATE_REGIST_INFO = "0";
	/**

	 * 完善第一步信息

	 */
	public static final String USER_STATE_FIRST_INFO = "1";
	/**

	 * 完善第二步信息

	 */
	public static final String USER_STATE_SECOND_INFO = "2";
	/**

	 * 已完善信息

	 */
	public static final String USER_STATE_FINISH_INFO = "3";
	/**

	 * 已通过身份审核

	 */
	public static final String USER_STATE_AUDIT_INFO = "4";
	/**

	 * 没有通过身份审核

	 */
	public static final String USER_STATE_AUDIT_INFO_FAIL = "5";
	/**

	 * 真信已返回审核信息

	 */
	public static final String USER_STATE_ZX_FINISH = "6";

	// 用户信息认证状态

	/**

	 * 认证未完成（初始状态）

	 */
	public static final String USER_AUTH_STATE_REGIST = "0";
	/**

	 * 认证已完成

	 */
	public static final String USER_AUTH_STATE_FINISH = "1";
	/**

	 * 认证中

	 */
	public static final String USER_AUTH_STATE_RUNNING = "2";
	/**

	 * 认证失败

	 */
	public static final String USER_AUTH_STATE_FAILED = "3";
	
	/**
	 * 请重新认证
	 */
	//public static final String USER_AUTH_STATE_AGAIN = "4";

	// 借款状态常量-- user表info_state字段

	/**

	 * 未申请借款

	 */
	public static final String USER_STATE_UNLOAN_INFO = "0";
	/**

	 * 发起借款请求，等待审核

	 */
	public static final String USER_STATE_LOAN_APPLY = "6";
	/**

	 * 借款审核拒绝

	 */
	public static final String USER_STATE_LOAN_APPLY_AUDIT_REFUSE = "7";
	/**

	 * 借款审核取消

	 */
	public static final String USER_STATE_LOAN_APPLY_AUDIT_CANCEL = "8";
	/**

	 * 借款审核通过，等待确认

	 */
	public static final String USER_STATE_LOAN_APPLY_AUDIT_SUCCESS = "9";
	/**

	 * 借款确认通过，等待放款审核

	 */
	public static final String USER_STATE_LOAN_APPLY_CONFIRM_SUCCESS = "10";
	/**

	 * 借款确认不通过

	 */
	public static final String USER_STATE_LOAN_APPLY_CONFIRM_FAIL = "11";
	/**

	 * 放款审核通过，等待放款

	 */
	public static final String USER_STATE_LOAN_AUDIT_SUCCESS = "12";
	/**

	 * 放款审核不通过

	 */
	public static final String USER_STATE_LOAN_AUDIT_FAIL = "13";

	// 放款详情页面

	/**

	 * 放款成功，等待还款

	 */
	public static final String USER_STATE_LOAN_SUCCESS = "14";

	/**

	 * 用户取消

	 */
	public static final String USER_STATE_LOAN_CANCEL = "15";

	/**

	 * 还款完成，已结束

	 */
	public static final String USER_STATE_REPAY_FINISH = "16";

	public static final Map<String, String> USER_AUDIT_INFO_MAP = new HashMap<String, String>();
	public static final Map<String, String> USER_STATE_INFO_MAP = new HashMap<String, String>();
	static {
		USER_AUDIT_INFO_MAP.put(USER_STATE_REGIST_INFO, "刚刚注册");
		USER_AUDIT_INFO_MAP.put(USER_STATE_FIRST_INFO, "完善第一步信息");
		USER_AUDIT_INFO_MAP.put(USER_STATE_SECOND_INFO, "完善第二步信息");
		USER_AUDIT_INFO_MAP.put(USER_STATE_FINISH_INFO, "已完善信息");
		USER_AUDIT_INFO_MAP.put(USER_STATE_AUDIT_INFO, "已通过审核");
		USER_AUDIT_INFO_MAP.put(USER_STATE_AUDIT_INFO_FAIL, "没有通过身份审核");

		USER_STATE_INFO_MAP.put(USER_STATE_UNLOAN_INFO, "未申请借款");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_APPLY, "发起借款请求，等待审核");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_APPLY_AUDIT_REFUSE, "借款审核拒绝");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_APPLY_AUDIT_CANCEL, "借款审核取消");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_APPLY_AUDIT_SUCCESS,
				"借款审核通过，等待确认");

		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_APPLY_CONFIRM_SUCCESS,
				"借款确认通过，等待放款审核");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_APPLY_CONFIRM_FAIL, "借款确认不通过");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_AUDIT_SUCCESS, "放款审核通过，等待放款");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_AUDIT_FAIL, "放款审核不通过");
		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_SUCCESS, "放款成功，等待还款");

		USER_STATE_INFO_MAP.put(USER_STATE_LOAN_CANCEL, "用户取消借款申请");
		USER_STATE_INFO_MAP.put(USER_STATE_REPAY_FINISH, "还款完成，已结束");
	}

	/**

	 * @Fields FIRST_APPLY : 初次申请

	 */
	public static final String FIRST_APPLY = "0";
	/**

	 * @Fields LOOP_LOAN : 循环贷

	 */
	public static final String LOOP_LOAN = "1";
	/**

	 * @Fields MANY_TIMES_APPLY : 多次申请

	 */
	public static final String MANY_TIMES_APPLY = "2";

	/**

	 * @Fields LOAN_CHECK_TYPE_APPALY_AUDIT : 借款申请审核类型-申请审核

	 */
	public static final String LOAN_CHECK_TYPE_APPALY_AUDIT = "1";
	/**

	 * @Fields LOAN_CHECK_TYPE_APPALY_CONFIRM : 借款申请审核类型-审核确认

	 */
	public static final String LOAN_CHECK_TYPE_APPALY_CONFIRM = "2";
	/**

	 * @Fields LOAN_CHECK_TYPE_LOAN_AUDIT : 放款审核

	 */
	public static final String LOAN_CHECK_TYPE_LOAN_AUDIT = "3";

	public final static String CURRENT_USER = "current_user";

	// 归属地查询appkey

	public static final String HOME_OWNERSHIP_APPKEY = "9fd8b69e89e9023717d5e8a10e577322";
	// 归属地查询请求地址

	public static final String HOME_OWNERSHIP_URL = "http://apis.juhe.cn/mobile/get";

	// apidata提供的归属地查询请求地址

	public static final String APIDATA_HOME_OWNERSHIP_URL = "http://sj.apidata.cn/";

	public static final Map<String, String> LOAN_TYPE_MAP = new HashMap<String, String>();
	static {
		LOAN_TYPE_MAP.put(FIRST_APPLY, "初次申请");
		LOAN_TYPE_MAP.put(LOOP_LOAN, "循环贷");
		LOAN_TYPE_MAP.put(MANY_TIMES_APPLY, "多次申请");
	}

	// loan表的loan_state 放款状态

	/**

	 * 借款待放款状态

	 */
	public static final String LOAN_WAIT_LOAN = "0";
	/**

	 * 借款放款失败状态

	 */
	public static final String LOAN_FAIL = "1";
	/**

	 * 借款放款成功状态

	 */
	public static final String LOAN_SUCCESS = "2";
	/**

	 * 放款中状态

	 */
	public static final String LOAN_ING = "3";

	/**

	 * 通知换卡状态

	 */
	public static final String LOAN_NOTICE = "6";
	/**

	 * 取消状态

	 */
	public static final String LOAN_CANCEL = "7";

	// loan表state字段常量

	/**

	 * 借款还未分发

	 */
	public static final String LOAN_UNDISTRIBUTED = "3";
	/**

	 * 借款已经分发

	 */
	public static final String LOAN_DISTRIBUTED = "4";

	/**

	 * 还款完成

	 */
	public static final String LOAN_REPAY_FINISH = "8";

	// loan 表 loan_way字段

	/**

	 * 自动放款方式

	 */
	public static final String LOAN_WAY_AUTO = "1";
	/**

	 * 手动放款方式

	 */
	public static final String LOAN_WAY_MANUAL = "2";

	public static final Map<String, String> LOAN_APPALY_STATE_MAP = new HashMap<String, String>();
	static {
		LOAN_APPALY_STATE_MAP.put(LOAN_APPLY_DISTRIBUTE, "审核提交申请 综合评估进行中");
		LOAN_APPALY_STATE_MAP.put(LOAN_APPLY_CANCEL, "用户取消审核");
		LOAN_APPALY_STATE_MAP.put(LOAN_AUDIT_WAITING, "已分发 等待综合评估");
		LOAN_APPALY_STATE_MAP.put(LOAN_AUDIT_SUCCESS, "综合评估通过  审核确认进行中");
		LOAN_APPALY_STATE_MAP.put(LOAN_AUDIT_FAIL, "综合评估失败拒绝  ");
		LOAN_APPALY_STATE_MAP.put(LOAN_AUDIT_CANCEL, "综合评估失败取消 ");
		LOAN_APPALY_STATE_MAP.put(LOAN_AUDIT_CONFIRM_SUCCESS,
				"审核确认通过  等待财务专员审核");
		LOAN_APPALY_STATE_MAP.put(LOAN_AUDIT_CONFIRM_FAIL, "审核确认不通过  ");
		LOAN_APPALY_STATE_MAP.put(LOAN_FINANCE_AUDIT_SUCCESS,
				"财务专员审核通过 等待财务主管放款");
		LOAN_APPALY_STATE_MAP.put(LOAN_FINANCE_AUDIT_FAIL, "财务专员审核不通过");
		LOAN_APPALY_STATE_MAP.put(LOAN_GRANT_FUNDS_SUCCESS, "已经发放借款资金 ");
		LOAN_APPALY_STATE_MAP.put(LOAN_FINISH, "借款结束");
	}
	/**

	 * @Dscrription:短信催收方式

	 * @author: haidong

	 * @date: 2016年1月18日 下午6:20:33

	 */
	public static final String MESSAGE_CHANNEL_TYPE = "message";
	/**

	 * @Dscrription:推送催收方式

	 * @author: haidong

	 * @date: 2016年1月18日 下午6:20:33

	 */
	public static final String PUSH_CHANNEL_TYPE = "push";
	/**

	 * @Dscrription:人工催收方式

	 * @author: haidong

	 * @date: 2016年1月18日 下午6:20:33

	 */
	public static final String HAND_CHANNEL_TYPE = "hand";
	/**

	 * @Dscrription:标签催收方式

	 * @author: haidong

	 * @date: 2016年1月18日 下午6:21:44

	 */
	public static final String LABEL_CHANNEL_TYPE = "label";

	/**

	 * @Dscrription:短信发送结果默认状态

	 * @author: haidong

	 * @date: 2016年1月19日 上午10:12:49

	 */
	public static final String MESSAGE_SEND_RESULT_DEFAULT_TYPE = "0";
	/**

	 * @Dscrription:短信发送结果成功状态

	 * @author: haidong

	 * @date: 2016年1月19日 上午10:12:49

	 */
	public static final String MESSAGE_SEND_RESULT_SUCCESS_TYPE = "1";
	/**

	 * @Dscrription:短信发送结果失败状态

	 * @author: haidong

	 * @date: 2016年1月19日 上午10:12:49

	 */
	public static final String MESSAGE_SEND_RESULT_FAIL_TYPE = "2";

	/**

	 * @Dscrription:发送个借款人的反馈信息类型

	 * @author: haidong

	 * @date: 2016年1月19日 下午2:38:25

	 */
	public static final String FEEDBACK_INFO_TYPE_SEND_USER = "0";
	/**

	 * @Dscrription:发送个借款人联系人的反馈信息类型

	 * @author: haidong

	 * @date: 2016年1月19日 下午2:38:25

	 */
	public static final String FEEDBACK_INFO_TYPE_SEND_USER_CONTACT = "1";
	/**

	 * @Dscrription:添加备注的反馈信息类型

	 * @author: haidong

	 * @date: 2016年1月19日 下午2:38:25

	 */
	public static final String FEEDBACK_INFO_TYPE_ADD_REMARK_TEMPLATE = "2";

	/**

	 * code表category--begin

	 */
	public static final String CODE_CATEGORY_REPAY_LABEL_TYPE = "RepayLabelType";
	/**

	 * code表category--end

	 */

	/**

	 * @Dscrription:修改费用待执行状态

	 * @author: haidong

	 * @date: 2016年1月20日 下午2:49:48

	 */
	public static final String MODIFY_FEE_EXECUTE_STATE_WAIT = "0";
	/**

	 * @Dscrription:修改费用执行成功状态

	 * @author: haidong

	 * @date: 2016年1月20日 下午2:49:59

	 */
	public static final String MODIFY_FEE_EXECUTE_STATE_SUCCESS = "1";
	/**

	 * @Dscrription:修改费用执行失败状态

	 * @author: haidong

	 * @date: 2016年1月20日 下午2:49:59

	 */
	public static final String MODIFY_FEE_EXECUTE_STATE_FAIL = "2";
	/**

	 * @Dscrription:修改费用待审核状态

	 * @author: haidong

	 * @date: 2016年1月20日 下午2:49:48

	 */
	public static final String MODIFY_FEE_CHECK_STATE_WAIT = "0";
	/**

	 * @Dscrription:修改费用审核通过状态

	 * @author: haidong

	 * @date: 2016年1月20日 下午2:49:59

	 */
	public static final String MODIFY_FEE_CHECK_STATE_SUCCESS = "1";
	/**

	 * @Dscrription:修改费用审核失败状态

	 * @author: haidong

	 * @date: 2016年1月20日 下午2:50:13

	 */
	public static final String MODIFY_FEE_CHECK_STATE_FAIL = "2";
	/**

	 * 删除状态

	 */
	public static final String REMOVE_STATE = "rm";
	/**

	 * @Dscrription:修改费用类型-改费

	 * @author: haidong

	 * @date: 2016年1月23日 下午4:34:03

	 */
	public static final String MODIFY_FEE_TYPE_MODIFY = "1";
	/**

	 * @Dscrription:修改费用类型-展期

	 * @author: haidong

	 * @date: 2016年1月23日 下午4:34:20

	 */
	public static final String MODIFY_FEE_TYPE_EXTENSION = "2";

	/**

	 * @Dscrription:黑名单状态-关闭中

	 */
	public static final String BLACK_TYPE_CLOSE = "0";
	/**

	 * @Dscrription:黑名单状态-到期自然结束

	 */
	public static final String BLACK_TYPE_OPEN = "1";
	/**

	 * @Dscrription:黑名单状态-提前释放

	 */
	public static final String BLACK_TYPE_EARLY = "2";

	// 银行卡类型

	/**

	 * 审核卡 （也可以进行支付）

	 */
	public static final String USER_BANK_TYPE_AUDIT = "0";
	/**

	 * 支付卡（只可以进行支付）

	 */
	public static final String USER_BANK_TYPE_PAY = "1";

	public static final String PAY_REMARK_CONTENT = "给用户放款";

	/**

	 * 短信模版列别 1：app登录

	 */
	public static final String MESSAGE_TEMPLATE_TYEP_APPLOGIN = "1";
	/**

	 * 短信模版列别 2：身份审核

	 */
	public static final String MESSAGE_TEMPLATE_TYEP_IDENTITY = "2";
	/**

	 * 短信模版列别 3：申请审核

	 */
	public static final String MESSAGE_TEMPLATE_TYEP_APPLY = "3";
	/**

	 * 短信模版列别 4：放款队列

	 */
	public static final String MESSAGE_TEMPLATE_TYEP_LOAN = "4";
	/**

	 * 短信模版列别 5：催收页面-发送给本人

	 */
	public static final String MESSAGE_TEMPLATE_TYEP_COLLECTION_TO_APPLY_USER = "5";
	/**

	 * 短信模版列别 6：催收页面-发送给用户联系人

	 */
	public static final String MESSAGE_TEMPLATE_TYEP_COLLECTION_USER_CONTACT = "6";
	/**

	 * @Dscrription:短信模版列别7：催收页面-添加备注

	 * @author: haidong

	 * @date: 2016年2月1日 下午4:17:06

	 */
	public static final String MESSAGE_TEMPLATE_TYPE_ADD_REMARK = "7";
	/**

	 * @Dscrription:短信模版列别8：审核页面-附件提醒

	 * @author: haidong

	 * @date: 2016年3月7日 下午3:59:41

	 */
	public static final String MESSAGE_TEMPLATE_TYPE_ATTACHMENT_REMIND = "8";
	/**

	 * @Dscrription:短信模版列别9：取消放款类型

	 * @author: haidong

	 * @date: 2016年3月7日 下午3:59:41

	 */
	public static final String MESSAGE_TEMPLATE_TYPE_CANCEL_LOAN = "9";

	/**

	 * @Dscrription:短信模版列别10：提醒还款

	 * @author: haidong

	 * @date: 2016年3月7日 下午3:59:41

	 */
	public static final String MESSAGE_TEMPLATE_TYPE_REMIND_REPAY = "10";
	/**

	 * @Dscrription:短信模版列别11：当日提醒还款

	 * @author: haidong

	 * @date: 2016年3月7日 下午3:59:41

	 */
	public static final String MESSAGE_TEMPLATE_TYPE_REMIND_REPAY_TODAY = "11";

	/**

	 * @Fields MESSAGE_TEMPLATE_TYPE_SHAN_SIGN_FAIL : 短信模版列别12:闪信签约失败

	 */
	public static final String MESSAGE_TEMPLATE_TYPE_SHAN_SIGN_FAIL = "12";

	/**

	 * @Dscrription:利率修改等待审核状态

	 * @author: haidong

	 * @date: 2016年1月29日 下午5:28:11

	 */
	public static final String RATING_APPLY_WAIT_CHECK = "0";
	/**

	 * @Dscrription:利率修改审核拒绝状态

	 * @author: haidong

	 * @date: 2016年1月29日 下午5:28:24

	 */
	public static final String RATING_APPLY_FAIL_CHECK = "1";
	/**

	 * @Dscrription:利率修改审核通过状态

	 * @author: haidong

	 * @date: 2016年1月29日 下午5:28:24

	 */
	public static final String RATING_APPLY_SUCCESS_CHECK = "2";
	/**

	 * @Dscrription:利率修改无效状态

	 * @author: haidong

	 * @date: 2016年1月29日 下午5:28:24

	 */
	public static final String RATING_APPLY_INVALID_CHECK = "3";

	/**

	 * @Dscrription:用户换卡记录的放款状态-未放款

	 * @author: haidong

	 * @date: 2016年2月25日 上午9:41:08

	 */
	public static final String CHANGE_CARD_LOAN_STATE_WAIT = "0";
	/**

	 * @Dscrription:用户换卡记录的放款状态-失败

	 * @author: haidong

	 * @date: 2016年2月25日 上午9:41:08

	 */
	public static final String CHANGE_CARD_LOAN_STATE_FAIL = "1";
	/**

	 * @Dscrription:用户换卡记录的放款状态-成功

	 * @author: haidong

	 * @date: 2016年2月25日 上午9:41:08

	 */
	public static final String CHANGE_CARD_LOAN_STATE_SUCCESS = "2";

	// 推广渠道 需要统计的数量类型

	/**

	 * 注册数

	 */
	public static final String CHANNEL_TYPE_REGIST = "0";
	/**

	 * 身份数

	 */
	public static final String CHANNEL_TYPE_IDENTITY = "1";
	/**

	 * 新增申请人数

	 */
	public static final String CHANNEL_TYPE_ADD_APPLY_PEOPLE = "2";
	/**

	 * 新增申请人次

	 */
	public static final String CHANNEL_TYPE_ADD_APPLY_COUNT = "3";
	/**

	 * 首次通过人数

	 */
	public static final String CHANNEL_TYPE_FIRST_PASSED = "4";
	/**

	 * 通过人次

	 */
	public static final String CHANNEL_TYPE_PASSED = "5";
	/**

	 * 循环贷次数

	 */
	public static final String CHANNEL_TYPE_XHD = "6";

	/**

	 * 还款类型,支付宝

	 */
	public static String REPAY_RECORD_TYPE_ALIPAY = "1";
	/**

	 * 还款类型,银联

	 */
	public static String REPAY_RECORD_TYPE_UNIONPAY = "2";
	/**

	 * 还款类型,融宝

	 */
	public static String REPAY_RECORD_TYPE_REAPAL = "3";
	/**

	 * 还款类型,闪信代扣

	 */
	public static String REPAY_RECORD_TYPE_SHAN = "4";
	/**

	 * 还款类型,连连分期付

	 */
	public static String REPAY_RECORD_TYPE_LIAN = "5";
	/**

	 * 还款类型,连连分期付(用户主动还)

	 */
	public static String REPAY_RECORD_TYPE_LIAN_INITIATIVE = "6";

	public static final Map<String, String> REPAY_RECORD_TYPE_MAP = new HashMap<String, String>() {
		{
			put(REPAY_RECORD_TYPE_ALIPAY, "支付宝账户");
			put(REPAY_RECORD_TYPE_UNIONPAY, "银联账户");
			put(REPAY_RECORD_TYPE_REAPAL, "融宝金融账户（朱尘）");
			put(REPAY_RECORD_TYPE_SHAN, "闪信代扣");
			put(REPAY_RECORD_TYPE_LIAN, "连连分期付");
			put(REPAY_RECORD_TYPE_LIAN_INITIATIVE, "连连分期付(用户主动还)");
		}
	};

	/**

	 * @Fields SHANQD_IS_SIGN_TRUE :银行卡闪信签约状态 已签约

	 */
	public static String SHANQD_IS_SIGN_TRUE = "1";
	/**

	 * @Fields SHANQD_IS_SIGN_FALSE : 银行卡闪信签约状态 未签约

	 */
	public static String SHANQD_IS_SIGN_FALSE = "0";

	/**

	 * @Fields USER_CLASSIFY_COMMON : 普通用户

	 */
	public static String USER_CLASSIFY_COMMON = "0";
	/**

	 * @Fields USER_CLASSIFY_DOUBTFUL : 可疑用户

	 */
	public static String USER_CLASSIFY_DOUBTFUL = "100";

	public static final Map<String, String> USER_CLASSIFY_MAP = new HashMap<String, String>() {
		{
			put(USER_CLASSIFY_COMMON, "普通用户");
			put(USER_CLASSIFY_DOUBTFUL, "可疑用户");
		}
	};
	public static final Map<String, String> BAIRONG_DECISION_NAMES = new HashMap<String, String>() {
		{
			put("Accept", "可信任");
			put("Reject", "不可信任");
			put("Review", "有嫌疑");
		}
	};
	public static final Map<String, String> BAIRONG_FACILITY_DATES = new HashMap<String, String>() {
		{
			put("1", "有异常");
			put("0", "无异常");
			put("99", "系统异常");
			put("98", "用户输入信息不足");
		}
	};

	public static final Map<String, String> BAIRONG_TYPE_DATES = new HashMap<String, String>() {
		{
			put("specialList_c", "specialList_c");
			put("rule", "rule");
			put("sl", "sl");
		}
	};

	public static final Map<String, String> BAIRONG_VALUE_DATES = new HashMap<String, String>() {
		{
			put("0", "本人中标");
			put("1", "直系亲属中标");
			put("2", "好友或远亲中标 ");
		}
	};
	public static final Map<String, String> BAIRONG_NAME_DATES = new HashMap<String, String>() {
		{
			put("sl_id_bank_bad", "通过身份证查询银行不良");
			put("sl_id_bank_overdue", "通过身份证查询银行短时逾期");
			put("sl_id_bank_fraud", "通过身份证查询银行欺诈");
			put("sl_id_bank_refuse", "通过身份证查询银行拒绝");
			put("sl_id_p2p_bad", "通过身份证查询小贷或P2P不良");
			put("sl_id_p2p_overdue", "通过身份证查询小贷或P2P短时逾期");
			put("sl_id_p2p_fraud", "通过身份证查询小贷或P2P欺诈");
			put("sl_id_p2p_refuse", "通过身份证查询小贷或P2P拒绝");
			put("sl_id_nbank_mc_bad", "通过身份证查询小贷不良");
			put("sl_id_nbank_mc_overdue", "通过身份证查询小贷短时逾期");
			put("sl_id_nbank_mc_fraud", "通过身份证查询小贷欺诈");
			put("sl_id_nbank_mc_refuse", "通过身份证查询小贷拒绝");
			put("sl_id_nbank_cf_bad", "通过身份证查询消费金融不良");
			put("sl_id_nbank_cf_overdue", "通过身份证查询消费金融短时逾期");
			put("sl_id_nbank_other_fraud", "通过身份证查询非银其他欺诈");
			put("sl_id_nbank_other_refuse", "通过身份证查询非银其他拒绝");
			put("sl_lm_cell_bank_bad", "通过联系人手机查询银行不良");
			put("sl_lm_cell_bank_overdue", "通过联系人手机查询银行短时逾期");
			put("sl_lm_cell_bank_fraud", "通过联系人手机查询银行欺诈");
			put("sl_lm_cell_bank_refuse", "通过联系人手机查询银行拒绝");
			put("sl_lm_cell_phone_overdue", "通过联系人手机查询电信欠费");
			put("sl_lm_cell_nbank_p2p_bad", "通过联系人手机查询P2P不良");
			put("sl_lm_cell_nbank_p2p_overdue", "通过联系人手机查询P2P短时逾期");
			put("sl_lm_cell_nbank_p2p_fraud", "通过联系人手机查询P2P欺诈");
			put("sl_lm_cell_nbank_p2p_refuse", "通过联系人手机查询P2P拒绝");
			put("sl_lm_cell_nbank_mc_bad", "通过联系人手机查询小贷不良");
			put("sl_lm_cell_nbank_mc_overdue", "通过联系人手机查询小贷短时逾期");
			put("sl_lm_cell_nbank_mc_fraud", "通过联系人手机查询小贷欺诈");
			put("sl_lm_cell_nbank_mc_refuse", "通过联系人手机查询小贷拒绝");
			put("sl_lm_cell_nbank_cf_bad", "通过联系人手机查询消费金融不良");
			put("sl_lm_cell_nbank_cf_overdue", "通过联系人手机查询消费金融短时逾期");
			put("sl_lm_cell_nbank_cf_fraud", "通过联系人手机查询消费金融欺诈");
			put("sl_lm_cell_nbank_cf_refuse", "通过联系人手机查询消费金融拒绝");
			put("sl_lm_cell_nbank_other_bad", "通过联系人手机查询非银其他不良");
			put("sl_lm_cell_nbank_other_overdue", "通过联系人手机查询非银其他短时逾期");
			put("sl_lm_cell_nbank_other_fraud", "通过联系人手机查询非银其他欺诈");
			put("sl_lm_cell_nbank_other_refuse", "通过联系人手机查询非银其他拒绝");
			put("sl_cell_bank_bad", "通过手机号查询银行不良");
			put("sl_cell_bank_overdue", "通过手机号查询银行短时逾期");
			put("sl_cell_bank_fraud", "通过手机号查询银行欺诈");
			put("sl_cell_bank_refuse", "通过手机号查询银行拒绝");
			put("sl_cell_p2p_bad", "通过手机号查询小贷或P2P不良");
			put("sl_cell_p2p_overdue", "通过手机号查询小贷或P2P短时逾期");
			put("sl_cell_p2p_fraud", "通过手机号查询小贷或P2P欺诈");
			put("sl_cell_p2p_refuse", "通过手机号查询小贷或P2P拒绝");
			put("sl_cell_phone_overdue", "通过手机号查询电信欠费");
			put("sl_cell_nbank_p2p_bad", "通过手机号查询P2P不良");
			put("sl_cell_nbank_p2p_overdue", "通过手机号查询P2P短时逾期");
			put("sl_cell_nbank_p2p_fraud", "通过手机号查询P2P欺诈");
			put("sl_cell_nbank_p2p_refuse", "通过手机号查询P2P拒绝");
			put("sl_cell_nbank_mc_bad", "通过手机号查询小贷不良");
			put("sl_cell_nbank_mc_overdue", "通过手机号查询小贷短时逾期");
			put("sl_cell_nbank_mc_fraud", "通过手机号查询小贷欺诈");
			put("sl_cell_nbank_mc_refuse", "通过手机号查询小贷拒绝");
			put("sl_cell_nbank_cf_bad", "通过手机号查询消费金融不良");
			put("sl_cell_nbank_cf_overdue", "通过手机号查询消费金融短时逾期");
			put("sl_cell_nbank_cf_fraud", "通过手机号查询消费金融欺诈");
			put("sl_cell_nbank_cf_refuse", "通过手机号查询消费金融拒绝");
			put("sl_cell_nbank_other_bad", "通过手机号查询非银其他不良");
			put("sl_cell_nbank_other_overdue", "通过手机号查询非银其他短时逾期");
			put("sl_cell_nbank_other_fraud", "通过手机号查询非银其他欺诈");
			put("sl_cell_nbank_other_refuse", "通过手机号查询非银其他拒绝");
			put("sl_gid_bank_bad", "通过百融标识查询银行不良");
			put("sl_gid_bank_overdue", "通过百融标识查询银行短时逾期");
			put("sl_gid_bank_fraud", "通过百融标识查询银行欺诈");
			put("sl_gid_bank_refuse", "通过百融标识查询银行拒绝");
			put("sl_gid_p2p_bad", "通过百融标识查询小贷或P2P不良");
			put("sl_gid_p2p_overdue", "通过百融标识查询小贷或P2P短时逾期");
			put("sl_gid_p2p_fraud", "通过百融标识查询小贷或P2P欺诈");
			put("sl_gid_p2p_refuse", "通过百融标识查询小贷或P2P拒绝");
			put("sl_gid_phone_overdue", "通过百融标识查询电信欠费");
			put("sl_gid_nbank_p2p_bad", "通过百融用户全局标识查询P2P不良");
			put("sl_gid_nbank_p2p_overdue", "通过百融用户全局标识查询P2P短时逾期");
			put("sl_gid_nbank_p2p_fraud", "通过百融用户全局标识查询P2P欺诈");
			put("sl_gid_nbank_p2p_refuse", "通过百融用户全局标识查询P2P拒绝");
			put("sl_gid_nbank_mc_bad", "通过百融用户全局标识查询小贷不良");
			put("sl_gid_nbank_mc_overdue", "通过百融用户全局标识查询小贷短时逾期");
			put("sl_gid_nbank_mc_fraud", "通过百融用户全局标识查询小贷欺诈");
			put("sl_gid_nbank_mc_refuse", "通过百融用户全局标识查询小贷拒绝");
			put("sl_gid_nbank_cf_bad", "通过百融用户全局标识查询消费金融不良");
			put("sl_gid_nbank_cf_overdue", "通过百融用户全局标识查询消费金融短时逾期");
			put("sl_gid_nbank_cf_fraud", "通过百融用户全局标识查询消费金融欺诈");
			put("sl_gid_nbank_cf_refuse", "通过百融用户全局标识查询消费金融拒绝");
			put("sl_gid_nbank_other_bad", "通过百融用户全局标识查询非银其他不良");
			put("sl_gid_nbank_other_overdue", "通过百融用户全局标识查询非银其他短时逾期");
			put("sl_gid_nbank_other_fraud", "通过百融用户全局标识查询非银其他欺诈");
			put("sl_gid_nbank_other_refuse", "通过百融用户全局标识查询非银其他拒绝");
		}
	};

	// 云融正通短信平台错误编码对应错误信息

	public static final Map<String, String> YUNRONGZHENGTONG_ERROR_MESSAGES = new HashMap<String, String>() {
		{
			put("-9", "用户名为空");
			put("-1", "用户名或口令错误");
			put("-2", "IP验证错误");
			put("-3", "定时日期错误");
			put("-10", "余额不足");
			put("-101", "userId为空");
			put("102", "目标号码为空");
			put("103", "短信内容为空");
			put("-104", "群发手机号码大于200个或短信群发号码个数不能大于100条");
			put("200", "目标号码错误");
			put("201", "目标号码在黑名单中");
			put("202", "内容包含敏感单词");
			put("203", "特服号未分配");
			put("204", "优先级错误(可以不传只进行发送)或分配通道错误");
			put("999", "其他异常");
			put("-999", "其它异常，短信内容可能为空");
		}
	};

	public static final Map<String, String> HONGLIAN95_CODE_MESSAGES = new HashMap<String, String>() {
		{
			put("00", "提交成功");
			put("1", "参数不完整");
			put("2", "鉴权失败（包括：用户状态不正常、密码错误、用户不存在、地址验证失败，黑户）");
			put("3", "号码数量超出50条");
			put("4", "发送失败");
			put("5", "余额不足");
			put("6", "发送内容含屏蔽词");
			put("7", "短信内容超出350个字");
			put("72", "内容被审核员屏蔽");
			put("8", "号码列表中没有合法的手机号码或手机号为黑名单或验证码类每小时超过6条");
			put("9", "夜间管理，不允许一次提交超过20个号码");
			put("10", "{txt}不应当出现在提交数据中，请修改[模板类账号]");
			put("11", "模板匹配成功[模板类必审、免审账号]");
			put("12", "未匹配到合适模板，已提交至审核员审核[模板类必审账号]");
			put("13", "未匹配到合适模板，无法下发，请修改[模板类免审账号]");
			put("14", "该账户没有模板[模板类账号]");
			put("15", "操作失败[模板类账号]");
			put("01", "手机号码为黑名单");
		}
	};

	/**

	 * 催收备注-承诺还款

	 */
	public static String REMARK_LABEL_NORMAL = "0";
	/**

	 * 催收备注-失联

	 */
	public static String REMARK_LABEL_LOSS = "1";
	/**

	 * 催收备注-可联

	 */
	public static String REMARK_LABEL_CONTACT = "2";
	/**

	 * 催收备注-谈判中

	 */
	public static String REMARK_LABEL_NEGOTIATING = "3";
	/**

	 * 催收备注-无诚意

	 */
	public static String REMARK_LABEL_INSINCERITY = "4";
	/**

	 * 催收备注-不良嗜好

	 */
	public static String REMARK_LABEL_BAD_HABIT = "5";
	/**

	 * 催收备注-跳票

	 */
	public static String REMARK_LABEL_BOUNCED_CHECK = "6";
	/**

	 * 催收备注-特殊案件

	 */
	public static String REMARK_LABEL_SPECIAL = "7";
	/**
	 * 催收备注-电话设置
	 */
	public static String REMARK_LABEL_PHONESET = "8";
	/**
	 * 催收备注-无人接听
	 */
	public static String REMARK_LABEL_NOBODY = "9";
	/**
	 * 催收备注-关机
	 */
	public static String REMARK_LABEL_TURNOFF = "10";
	/**
	 * 催收备注-联系人可联
	 */
	public static String REMARK_LABEL_LINKABLE = "11";
	/**
	 * 催收备注-电话无效
	 */
	public static String REMARK_LABEL_PHONELOSS = "12";

	public static final Map<String, String> REMARK_LABEL_MAP = new HashMap<String, String>() {
		{
			put(REMARK_LABEL_NORMAL, "承诺还款");
			put(REMARK_LABEL_LOSS, "失联");
			put(REMARK_LABEL_CONTACT, "可联");
			put(REMARK_LABEL_NEGOTIATING, "谈判中");
			put(REMARK_LABEL_INSINCERITY, "无诚意");
			put(REMARK_LABEL_BOUNCED_CHECK, "跳票");
			put(REMARK_LABEL_BAD_HABIT, "不良嗜好");
			put(REMARK_LABEL_SPECIAL, "特殊案件");
			put(REMARK_LABEL_PHONESET,"电话设置");
			put(REMARK_LABEL_NOBODY,"无人接听");
			put(REMARK_LABEL_TURNOFF,"关机");
			put(REMARK_LABEL_LINKABLE,"联系人可联");
			put(REMARK_LABEL_PHONELOSS,"电话无效");
		}
	};
	
	public static final Map<String, String> REPAY_REMARK_STATE_MAP = new HashMap<String, String>(){
        {
            put("1", "代偿");
            put("2", "转告");
            put("3", "不配合");
            put("4", "无人接听");
            put("5", "电话设置");
            put("6", "停机");
            put("7", "空号");
            put("8", "关机");
            put("9", "无法接通");
        }
    };

	// 规则计算的状态

	/**

	 * 通过

	 */
	public static final Integer PASS_RULE = 200;
	/**

	 * 取消

	 */
	public static final Integer CANCEL_RULE = 400;
	/**

	 * 拒绝

	 */
	public static final Integer REFUSE_RULE = 403;
	/**

	 * 转人工

	 */
	public static final Integer MANUAL_RULE = 500;

	// 对应user_info表中idcard_authen字段：

	/**

	 * 不可信

	 */
	public static final String ZX_UNTRUSTED = "-1";
	/**

	 * 未认证

	 */
	public static final String ZX_NOT_CERTIFIED = "0";
	/**

	 * 部分可信，需要人工审核

	 */
	public static final String ZX_TRANSF_ARTIFICIAL = "1";
	/**

	 * 基本可信

	 */
	public static final String ZX_BASIC_TRUST = "2";
	/**

	 * 高度可信

	 */
	public static final String ZX_HIGHLY_RELIABLE = "3";

	// 记录首次借款通过的笔数^M

	public static int FIRST_LOAN_COUNT = 0;
	// 记录首次借款百融支付消费规则通过的笔数

    public static int BAIRONG_PAY_PASS_COUNT = 0;

    // 活动状态

    public static String ACTIVITY_STATUS_WAIT = "1";
    public static String ACTIVITY_STATUS_START = "2";
    public static String ACTIVITY_STATUS_END = "3";

    public static final Map<String, String> ACTIVITY_STATUS_MAP = new HashMap<String, String>() {
        {
            put(ACTIVITY_STATUS_WAIT, "未开始");
            put(ACTIVITY_STATUS_START, "进行中");
            put(ACTIVITY_STATUS_END, "已结束");
        }
    };

    /**

     * 活动分享-新建状态

     */
    public static final String ACTIVITY_SHARE_CREATE = "1";
    /**

     * 活动分享-支付中状态

     */
    public static final String ACTIVITY_SHARE_PAY = "2";
    /**

     * 活动分享-支付成功状态

     */
    public static final String ACTIVITY_SHARE_PAY_SUCESS = "3";
    /**

     * 活动分享-支付失败状态

     */
    public static final String ACTIVITY_SHARE_PAY_FAILE = "4";

    public static final Map<String, String> USER_ACTIVITY_STATUS_MAP = new HashMap<String, String>() {
        {
            put(ACTIVITY_SHARE_CREATE, "待支付");
            put(ACTIVITY_SHARE_PAY, "支付中");
            put(ACTIVITY_SHARE_PAY_SUCESS, "支付成功");
            put(ACTIVITY_SHARE_PAY_FAILE, "支付失败");
        }
    };
    /**

     * 活动状态--新建

     */
    public static final String ACTIVITY_STATE_NEW = "0";
    /**

     * 活动状态--进行中

     */
    public static final String ACTIVITY_STATE_RUNNING = "1";
    /**

     * 活动状态--已结束

     */
    public static final String ACTIVITY_STATE_END = "2";
    
    /**
     * 待审核
     */
    public static final String APPLY_LOAN_WAITCHECK = "0";
    /**
     * 申请审核（一审）
     */
    public static final String APPLY_LOAN_CHECK = "1";
    /**
     * 审核确认（二审）
     */
    public static final String APPLY_CONFIRM_CHECK = "2";
    /**
     * 放款审核
     */
    public static final String APPLY_CHECK = "3";
    /**
     * 已通过所有审核
     */
    public static final String APPLY_CHECK_PASS = "4";


}