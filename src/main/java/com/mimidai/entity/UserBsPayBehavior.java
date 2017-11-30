package com.mimidai.entity;


import java.util.Date;

/**
 * 百融-支付消费行为偏好
 * @author liaowei
 * @date 2017年4月20日 下午6:07:49
 */
public class UserBsPayBehavior {

	private Long userId;
	
	/**
	 * 卡属性。debit代表借记卡，"credit"代表信用卡
	 */
	private String dcFlag;
	/**
	 * 卡状态得分表。"一年内使用状态的分类，取值：
		1：不活跃客户
		2：长期忠诚客户
		3：活跃上升客户
		4：活跃下降客户
		5：自激活或新客户
		6：睡眠客户"
	 */
	private String cstScore;
	
	/**
	 * 套现模型得分（仅信用卡）。"未来6个月内可能发生套现的得分指标，取值：
		0~1000整数：数值越大表示套现可能越小( <300分： 高套现风险；300-499分：中高套现风险；500-699分：中套现风险；700-899分：中低套现风险；>=900分：低套现风险）
		9990：（特殊赋值）表示套现可能性极大
		9991：（特殊赋值）表示套现可能性极小"
	 */
	private String cotScore;
	
	/**
	 * 套现模型分类（仅信用卡）。"未来6个月内发生套现的分类指标，取值：
		0~11整数：数值越大表示逾期风险越小 ( <=3： 套现分数<300分，高套现风险；4-5：套现分数 300-499分，中高套现风险；6-7：套现分数500-699分，中套现风险；8-9：套现分数700-899分，中低套现风险；10-11：套现分数900分及以上，低套现风险）
		9990：（特殊赋值）表示套现可能性极大
		9991：（特殊赋值）表示套现可能性极小"
	 */
	private String cotCluster;
	
	/**
	 * 消费趋势得分。"代表最近3个月与过去3个月相比消费变动趋势与全行业对比情况，按信用卡借记卡分类比较。
		内容代表的含义：
		1：（与行业相比）显著低
		2：（与行业相比）低
		3：（与行业相比）相当
		4：（与行业相比）高
		5：（与行业相比）显著高
		6：（与行业相比）不稳定
		Null：无交易行为（最近6个月）"
	 */
	private String cntScore;
	
	/**
	 * 消费能力得分。"3个月内的消费能力与全行业对比情况，按信用卡借记卡分类比较，取值：
		内容代表的含义：
		1：（与行业相比）显著低
		2：（与行业相比）低
		3：（与行业相比）相当
		4：（与行业相比）高
		5：（与行业相比）显著高
		6：高额消费（信用卡20W+/借记卡30W+）
		Null：无交易行为（最近3个月）"
	 */
	private String cnaScore;
	
	/**
	 * 持卡人价值得分。"最近6个月的交易行为特征，使用模型设计出的持卡人价值类型，用于精准营销目标筛选、差异化管理客群。
	 	取值：
		1：高端人群
		2：文艺小资
		3：白领人士
		4：潜力客户
		5：打拼生活
		6：大宗交易
		7：日常超市
		8：小微批发
		9：低频消费
		Null：无交易行为（最近6个月）"
	 */
	private String chvScore;
	
	/**
	 * 消费自由度得分。"最近6个月内持卡人在这张卡上的消费习惯，
	 	取值介于0和1000之间，数值越高说明这张卡上承载了越多的非生活必须类消费，诠释了持卡人在使用银行卡支付方面表现的财富水平。取值：
		0~1000整数：数值越大表示消费自由度越高，卡上承载了越多的非生活必须类消费（701-1000：高自由度；301-700:    中自由度；0-300：     低自由度）
		9991：（特殊赋值）商业性消费、一次性大额消费
		9992：（特殊赋值）近三个月无交易行为
		9993：（特殊赋值）交易次数过少 
		Null： 近六个月无交易"
	 */
	private String dsiScore;
	
	/**
	 * 消费自由度分类。"最近6个月内持卡人在这张卡上的消费习惯，根据消费自由度模型得分，数值越高说明这张卡上承载了越多的非生活必须类消费，诠释了持卡人在使用银行卡支付方面表现的财富水平。取值：
		0~11整数：数值越大表示消费自由度越高，卡上承载了越多的非生活必须类消费（8-11：高自由度；4-7:    中自由度；0-3：  低自由度）
		9991：（特殊赋值）商业性消费、一次性大额消费
		9992：（特殊赋值）近三个月无交易行为
		9993：（特殊赋值）交易次数过少 
		Null：近六个月无交易"
	 */
	private String dsiCluster;
	
	/**
	 * 风险得分（仅信用卡）。"根据风险预测模型计算出某卡在未来6个月内发生90天以上逾期风险的得分指标。衡量持卡人信用风险的重要指标，可在风险发生前预警。取值：
		0~1000整数：数值越大表示逾期风险越小 ( <300分： 高逾期风险；300-499分：中高逾期风险；500-699分：中逾期风险；700-899分：中低逾期风险；>=900分：低逾期风险）
		9990：表示风险极大
		9991：表示风险极小"
	 */
	private String rskScore;
	
	/**
	 * 风险得分分类（仅信用卡）。
	 */
	private String rskCluster;
	
	/**
	 * 钱包位置得分
	 */
	private String wlpScore;
	
	/**
	 * 跨境得分。
	 */
	private String crbScore;
	
	/**
	 * 跨境得分分类
	 */
	private String crbCluster;
	
	/**
	 * 消费综合评分
	 */
	private String summaryScore;
	
	/**
	 * 消费偏好得分
	 */
	private String cnpScore;
	
	/**
	 * 近1个月交易笔数
	 */
	private String rfm1Var1;
	
	/**
	 * 近1个月交易金额
	 */
	private String rfm1Var2;
	
	/**
	 * 近1次交易时间距上月底天数
	 */
	private String day1Var1;
	
	/**
	 * 近1个活动省市
	 */
	private String loc1Var1;
	
	/**
	 * 近3个月发生交易月份数
	 */
	private String mon3Var1;
	
	/**
	 * 近3个月交易金额
	 */
	private String rfm3Var1;
	/**
	 * 近3个月交易笔数
	 */
	private String rfm3Var2;
	/**
	 * 近3个月最大交易金额
	 */
	private String rfm3Var3;
	/**
	 * 近3个月最小交易金额
	 */
	private String rfm3Var4;
	/**
	 * 近3个月笔均交易金额
	 */
	private String rfm3Var5;
	/**
	 * 近3个月发生交易的MCC种类数
	 */
	private String mcc3Var1;
	
	/**
	 * 近6个月发生交易月份数
	 */
	private String mon6Var1;
	
	/**
	 * 近6个月交易金额
	 */
	private String rfm6Var1;
	/**
	 * 近6个月交易笔数
	 */
	private String rfm6Var2;
	/**
	 * 近6个月最大交易金额
	 */
	private String rfm6Var3;
	/**
	 * 近6个月最小交易金额
	 */
	private String rfm6Var4;
	/**
	 * 近6个月笔均交易金额
	 */
	private String rfm6Var5;
	/**
	 * 近6个月交易金额稳定性
	 */
	private String rfm6Var6;
	
	/**
	 * 近6个月发生交易的MCC种类数
	 */
	private String mcc6Var1;
	
	/**
	 * 近6个月活跃度标志（实际月）
	 */
	private String flag6Var1;
	/**
	 * 近6个月高中低消费人群标记
	 */
	private String flag6Var3;
	/**
	 * 近6个月线上消费标志 
	 */
	private String flag6Var4;
	/**
	 * 近6个月跨境标志
	 */
	private String flag6Var6;
	/**
	 * 近6个月消费强度标志（实际月）
	 */
	private String flag6Var8;
	
	/**
	 * 近6个月常用地区
	 */
	private String loc6Var11;
	/**
	 * 近12个月发生交易月份数
	 */
	private String mon12Var1;
	
	/**
	 * 近12个月交易金额
	 */
	private String rfm12Var1;
	/**
	 * 近12个月交易笔数
	 */
	private String rfm12Var2;
	/**
	 * 近12个月最大交易金额
	 */
	private String rfm12Var3;
	/**
	 * 近12个月最小交易金额
	 */
	private String rfm12Var4;
	/**
	 * 近12个月笔均交易金额
	 */
	private String rfm12Var5;
	/**
	 * 近12个月发生交易的MCC种类数
	 */
	private String rfm12Var6;
	/**
	 * 近12个月批发交易金额
	 */
	private String rfm12Var20;
	/**
	 * 近12个月餐饮交易金额
	 */
	private String rfm12Var21;
	/**
	 * 近12个月仓储超市交易金额
	 */
	private String rfm12Var22;
	/**
	 * 近12个月储蓄交易金额
	 */
	private String rfm12Var23;
	/**
	 * 近12个月批发交易笔数
	 */
	private String rfm12Var24;
	/**
	 * 近12个月餐饮交易笔数
	 */
	private String rfm12Var25;
	/**
	 * 近12个月仓储超市交易笔数
	 */
	private String rfm12Var26;
	/**
	 * 近12个月储蓄交易笔数
	 */
	private String rfm12Var27;
	/**
	 * 近12个月取现交易笔数
	 */
	private String rfm12Var29;
	/**
	 * 近12个月取现交易金额
	 */
	private String rfm12Var30;
	/**
	 * 近12个月跨境交易笔数
	 */
	private String rfm12Var39;
	/**
	 * 近12个月跨境交易金额
	 */
	private String rfm12Var40;
	/**
	 * 近12个月转出交易金额
	 */
	private String rfm12Var44;
	/**
	 * 近12个月转出交易笔数
	 */
	private String rfm12Var45;
	/**
	 * 近12个月转入交易金额
	 */
	private String rfm12Var47;
	/**
	 * 近12个月转入交易笔数
	 */
	private String rfm12Var48;
	/**
	 * 近12个月内周末交易笔数
	 */
	private String rfm12Var50;
	/**
	 * 近12个月内卫生类交易笔数 
	 */
	private String rfm12Var54;
	
	/**
	 * 银行卡号
	 */
	private String accountNo;
	/**
	 * 查询年月
	 */
	private String yearMonth;
	
	/**
	 * 近1个月消费金额
	 */
	private String totalAmt;
	
	/**
	 * 近1个月消费次数
	 */
	private String totalCnt;
	/**
	 * mcc第一（金额）
	 */
	private String mccAmt1;
	/**
	 * mcc第二（金额）
	 */
	private String mccAmt2;
	/**
	 * mcc第三（金额）
	 */
	private String mccAmt3;
	/**
	 * mcc第一（次数）
	 */
	private String mccCnt1;
	/**
	 * mcc第二（次数）
	 */
	private String mccCnt2;
	/**
	 * mcc第三（次数）
	 */
	private String mccCnt3;
	/**
	 * 最多消费次数所在城市
	 */
	private String transPlace;
	
	/**
	 * 夜消费（12:00-6:00）金额
	 */
	private String time0005Amt;
	/**
	 * 夜消费（12:00-6:00）次数
	 */
	private String time0005Cnt;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getDcFlag() {
		return dcFlag;
	}
	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}
	public String getCstScore() {
		return cstScore;
	}
	public void setCstScore(String cstScore) {
		this.cstScore = cstScore;
	}
	public String getCotScore() {
		return cotScore;
	}
	public void setCotScore(String cotScore) {
		this.cotScore = cotScore;
	}
	public String getCotCluster() {
		return cotCluster;
	}
	public void setCotCluster(String cotCluster) {
		this.cotCluster = cotCluster;
	}
	public String getCntScore() {
		return cntScore;
	}
	public void setCntScore(String cntScore) {
		this.cntScore = cntScore;
	}
	public String getCnaScore() {
		return cnaScore;
	}
	public void setCnaScore(String cnaScore) {
		this.cnaScore = cnaScore;
	}
	public String getChvScore() {
		return chvScore;
	}
	public void setChvScore(String chvScore) {
		this.chvScore = chvScore;
	}
	public String getDsiScore() {
		return dsiScore;
	}
	public void setDsiScore(String dsiScore) {
		this.dsiScore = dsiScore;
	}
	public String getDsiCluster() {
		return dsiCluster;
	}
	public void setDsiCluster(String dsiCluster) {
		this.dsiCluster = dsiCluster;
	}
	public String getRskScore() {
		return rskScore;
	}
	public void setRskScore(String rskScore) {
		this.rskScore = rskScore;
	}
	public String getRskCluster() {
		return rskCluster;
	}
	public void setRskCluster(String rskCluster) {
		this.rskCluster = rskCluster;
	}
	public String getWlpScore() {
		return wlpScore;
	}
	public void setWlpScore(String wlpScore) {
		this.wlpScore = wlpScore;
	}
	public String getCrbScore() {
		return crbScore;
	}
	public void setCrbScore(String crbScore) {
		this.crbScore = crbScore;
	}
	public String getCrbCluster() {
		return crbCluster;
	}
	public void setCrbCluster(String crbCluster) {
		this.crbCluster = crbCluster;
	}
	public String getSummaryScore() {
		return summaryScore;
	}
	public void setSummaryScore(String summaryScore) {
		this.summaryScore = summaryScore;
	}
	public String getCnpScore() {
		return cnpScore;
	}
	public void setCnpScore(String cnpScore) {
		this.cnpScore = cnpScore;
	}
	public String getRfm1Var1() {
		return rfm1Var1;
	}
	public void setRfm1Var1(String rfm1Var1) {
		this.rfm1Var1 = rfm1Var1;
	}
	public String getRfm1Var2() {
		return rfm1Var2;
	}
	public void setRfm1Var2(String rfm1Var2) {
		this.rfm1Var2 = rfm1Var2;
	}
	public String getDay1Var1() {
		return day1Var1;
	}
	public void setDay1Var1(String day1Var1) {
		this.day1Var1 = day1Var1;
	}
	public String getLoc1Var1() {
		return loc1Var1;
	}
	public void setLoc1Var1(String loc1Var1) {
		this.loc1Var1 = loc1Var1;
	}
	public String getMon3Var1() {
		return mon3Var1;
	}
	public void setMon3Var1(String mon3Var1) {
		this.mon3Var1 = mon3Var1;
	}
	public String getRfm3Var1() {
		return rfm3Var1;
	}
	public void setRfm3Var1(String rfm3Var1) {
		this.rfm3Var1 = rfm3Var1;
	}
	public String getRfm3Var2() {
		return rfm3Var2;
	}
	public void setRfm3Var2(String rfm3Var2) {
		this.rfm3Var2 = rfm3Var2;
	}
	public String getRfm3Var3() {
		return rfm3Var3;
	}
	public void setRfm3Var3(String rfm3Var3) {
		this.rfm3Var3 = rfm3Var3;
	}
	public String getRfm3Var4() {
		return rfm3Var4;
	}
	public void setRfm3Var4(String rfm3Var4) {
		this.rfm3Var4 = rfm3Var4;
	}
	public String getRfm3Var5() {
		return rfm3Var5;
	}
	public void setRfm3Var5(String rfm3Var5) {
		this.rfm3Var5 = rfm3Var5;
	}
	public String getMcc3Var1() {
		return mcc3Var1;
	}
	public void setMcc3Var1(String mcc3Var1) {
		this.mcc3Var1 = mcc3Var1;
	}
	public String getMon6Var1() {
		return mon6Var1;
	}
	public void setMon6Var1(String mon6Var1) {
		this.mon6Var1 = mon6Var1;
	}
	public String getRfm6Var1() {
		return rfm6Var1;
	}
	public void setRfm6Var1(String rfm6Var1) {
		this.rfm6Var1 = rfm6Var1;
	}
	public String getRfm6Var2() {
		return rfm6Var2;
	}
	public void setRfm6Var2(String rfm6Var2) {
		this.rfm6Var2 = rfm6Var2;
	}
	public String getRfm6Var3() {
		return rfm6Var3;
	}
	public void setRfm6Var3(String rfm6Var3) {
		this.rfm6Var3 = rfm6Var3;
	}
	public String getRfm6Var4() {
		return rfm6Var4;
	}
	public void setRfm6Var4(String rfm6Var4) {
		this.rfm6Var4 = rfm6Var4;
	}
	public String getRfm6Var5() {
		return rfm6Var5;
	}
	public void setRfm6Var5(String rfm6Var5) {
		this.rfm6Var5 = rfm6Var5;
	}
	public String getRfm6Var6() {
		return rfm6Var6;
	}
	public void setRfm6Var6(String rfm6Var6) {
		this.rfm6Var6 = rfm6Var6;
	}
	public String getMcc6Var1() {
		return mcc6Var1;
	}
	public void setMcc6Var1(String mcc6Var1) {
		this.mcc6Var1 = mcc6Var1;
	}
	public String getFlag6Var1() {
		return flag6Var1;
	}
	public void setFlag6Var1(String flag6Var1) {
		this.flag6Var1 = flag6Var1;
	}
	public String getFlag6Var3() {
		return flag6Var3;
	}
	public void setFlag6Var3(String flag6Var3) {
		this.flag6Var3 = flag6Var3;
	}
	public String getFlag6Var4() {
		return flag6Var4;
	}
	public void setFlag6Var4(String flag6Var4) {
		this.flag6Var4 = flag6Var4;
	}
	public String getFlag6Var6() {
		return flag6Var6;
	}
	public void setFlag6Var6(String flag6Var6) {
		this.flag6Var6 = flag6Var6;
	}
	public String getFlag6Var8() {
		return flag6Var8;
	}
	public void setFlag6Var8(String flag6Var8) {
		this.flag6Var8 = flag6Var8;
	}
	public String getLoc6Var11() {
		return loc6Var11;
	}
	public void setLoc6Var11(String loc6Var11) {
		this.loc6Var11 = loc6Var11;
	}
	public String getMon12Var1() {
		return mon12Var1;
	}
	public void setMon12Var1(String mon12Var1) {
		this.mon12Var1 = mon12Var1;
	}
	public String getRfm12Var1() {
		return rfm12Var1;
	}
	public void setRfm12Var1(String rfm12Var1) {
		this.rfm12Var1 = rfm12Var1;
	}
	public String getRfm12Var2() {
		return rfm12Var2;
	}
	public void setRfm12Var2(String rfm12Var2) {
		this.rfm12Var2 = rfm12Var2;
	}
	public String getRfm12Var3() {
		return rfm12Var3;
	}
	public void setRfm12Var3(String rfm12Var3) {
		this.rfm12Var3 = rfm12Var3;
	}
	public String getRfm12Var4() {
		return rfm12Var4;
	}
	public void setRfm12Var4(String rfm12Var4) {
		this.rfm12Var4 = rfm12Var4;
	}
	public String getRfm12Var5() {
		return rfm12Var5;
	}
	public void setRfm12Var5(String rfm12Var5) {
		this.rfm12Var5 = rfm12Var5;
	}
	public String getRfm12Var6() {
		return rfm12Var6;
	}
	public void setRfm12Var6(String rfm12Var6) {
		this.rfm12Var6 = rfm12Var6;
	}
	public String getRfm12Var20() {
		return rfm12Var20;
	}
	public void setRfm12Var20(String rfm12Var20) {
		this.rfm12Var20 = rfm12Var20;
	}
	public String getRfm12Var21() {
		return rfm12Var21;
	}
	public void setRfm12Var21(String rfm12Var21) {
		this.rfm12Var21 = rfm12Var21;
	}
	public String getRfm12Var22() {
		return rfm12Var22;
	}
	public void setRfm12Var22(String rfm12Var22) {
		this.rfm12Var22 = rfm12Var22;
	}
	public String getRfm12Var23() {
		return rfm12Var23;
	}
	public void setRfm12Var23(String rfm12Var23) {
		this.rfm12Var23 = rfm12Var23;
	}
	public String getRfm12Var24() {
		return rfm12Var24;
	}
	public void setRfm12Var24(String rfm12Var24) {
		this.rfm12Var24 = rfm12Var24;
	}
	public String getRfm12Var25() {
		return rfm12Var25;
	}
	public void setRfm12Var25(String rfm12Var25) {
		this.rfm12Var25 = rfm12Var25;
	}
	public String getRfm12Var26() {
		return rfm12Var26;
	}
	public void setRfm12Var26(String rfm12Var26) {
		this.rfm12Var26 = rfm12Var26;
	}
	public String getRfm12Var27() {
		return rfm12Var27;
	}
	public void setRfm12Var27(String rfm12Var27) {
		this.rfm12Var27 = rfm12Var27;
	}
	public String getRfm12Var29() {
		return rfm12Var29;
	}
	public void setRfm12Var29(String rfm12Var29) {
		this.rfm12Var29 = rfm12Var29;
	}
	public String getRfm12Var30() {
		return rfm12Var30;
	}
	public void setRfm12Var30(String rfm12Var30) {
		this.rfm12Var30 = rfm12Var30;
	}
	public String getRfm12Var39() {
		return rfm12Var39;
	}
	public void setRfm12Var39(String rfm12Var39) {
		this.rfm12Var39 = rfm12Var39;
	}
	public String getRfm12Var40() {
		return rfm12Var40;
	}
	public void setRfm12Var40(String rfm12Var40) {
		this.rfm12Var40 = rfm12Var40;
	}
	public String getRfm12Var44() {
		return rfm12Var44;
	}
	public void setRfm12Var44(String rfm12Var44) {
		this.rfm12Var44 = rfm12Var44;
	}
	public String getRfm12Var45() {
		return rfm12Var45;
	}
	public void setRfm12Var45(String rfm12Var45) {
		this.rfm12Var45 = rfm12Var45;
	}
	public String getRfm12Var47() {
		return rfm12Var47;
	}
	public void setRfm12Var47(String rfm12Var47) {
		this.rfm12Var47 = rfm12Var47;
	}
	public String getRfm12Var48() {
		return rfm12Var48;
	}
	public void setRfm12Var48(String rfm12Var48) {
		this.rfm12Var48 = rfm12Var48;
	}
	public String getRfm12Var50() {
		return rfm12Var50;
	}
	public void setRfm12Var50(String rfm12Var50) {
		this.rfm12Var50 = rfm12Var50;
	}
	public String getRfm12Var54() {
		return rfm12Var54;
	}
	public void setRfm12Var54(String rfm12Var54) {
		this.rfm12Var54 = rfm12Var54;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	public String getMccAmt1() {
		return mccAmt1;
	}
	public void setMccAmt1(String mccAmt1) {
		this.mccAmt1 = mccAmt1;
	}
	public String getMccAmt2() {
		return mccAmt2;
	}
	public void setMccAmt2(String mccAmt2) {
		this.mccAmt2 = mccAmt2;
	}
	public String getMccAmt3() {
		return mccAmt3;
	}
	public void setMccAmt3(String mccAmt3) {
		this.mccAmt3 = mccAmt3;
	}
	public String getMccCnt1() {
		return mccCnt1;
	}
	public void setMccCnt1(String mccCnt1) {
		this.mccCnt1 = mccCnt1;
	}
	public String getMccCnt2() {
		return mccCnt2;
	}
	public void setMccCnt2(String mccCnt2) {
		this.mccCnt2 = mccCnt2;
	}
	public String getMccCnt3() {
		return mccCnt3;
	}
	public void setMccCnt3(String mccCnt3) {
		this.mccCnt3 = mccCnt3;
	}
	public String getTransPlace() {
		return transPlace;
	}
	public void setTransPlace(String transPlace) {
		this.transPlace = transPlace;
	}
	public String getTime0005Amt() {
		return time0005Amt;
	}
	public void setTime0005Amt(String time0005Amt) {
		this.time0005Amt = time0005Amt;
	}
	public String getTime0005Cnt() {
		return time0005Cnt;
	}
	public void setTime0005Cnt(String time0005Cnt) {
		this.time0005Cnt = time0005Cnt;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
