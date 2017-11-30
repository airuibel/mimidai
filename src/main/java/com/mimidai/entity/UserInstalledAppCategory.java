package com.mimidai.entity;

/**
 * Created by zhangyu on 2017/10/13.
 */
public class UserInstalledAppCategory  {
    private Integer loanCnt;     //贷款类（400001）
    private Integer investCnt;   //投资类 （400002）
    private Integer betCnt;      //博彩类（400003）
    private Integer bankCnt;	 //银行类 （400004）
    private Integer creditCnt;   //征信类（400005）
    private Integer welfareCnt;  //福利类（400006）
    private Integer lifeCnt;     //生活类（400007）
    private Integer sensitiveCnt;//敏感类（400008）
    private Integer locationCnt; //定位类（400009）
    private Integer gameCnt;     //游戏类（400010）
    private Integer total;
    public Integer getLoanCnt() {
        return loanCnt;
    }
    public void setLoanCnt(Integer loanCnt) {
        this.loanCnt = loanCnt;
    }
    public Integer getInvestCnt() {
        return investCnt;
    }
    public void setInvestCnt(Integer investCnt) {
        this.investCnt = investCnt;
    }
    public Integer getBetCnt() {
        return betCnt;
    }
    public void setBetCnt(Integer betCnt) {
        this.betCnt = betCnt;
    }
    public Integer getBankCnt() {
        return bankCnt;
    }
    public void setBankCnt(Integer bankCnt) {
        this.bankCnt = bankCnt;
    }
    public Integer getCreditCnt() {
        return creditCnt;
    }
    public void setCreditCnt(Integer creditCnt) {
        this.creditCnt = creditCnt;
    }
    public Integer getWelfareCnt() {
        return welfareCnt;
    }
    public void setWelfareCnt(Integer welfareCnt) {
        this.welfareCnt = welfareCnt;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public Integer getLifeCnt() {
        return lifeCnt;
    }
    public void setLifeCnt(Integer lifeCnt) {
        this.lifeCnt = lifeCnt;
    }
    public Integer getSensitiveCnt() {
        return sensitiveCnt;
    }
    public void setSensitiveCnt(Integer sensitiveCnt) {
        this.sensitiveCnt = sensitiveCnt;
    }
    public Integer getLocationCnt() {
        return locationCnt;
    }
    public void setLocationCnt(Integer locationCnt) {
        this.locationCnt = locationCnt;
    }
    public Integer getGameCnt() {
        return gameCnt;
    }
    public void setGameCnt(Integer gameCnt) {
        this.gameCnt = gameCnt;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        UserInstalledAppCategory userInstalledAppCategory = (UserInstalledAppCategory) obj;

        if (total != null ? !total.equals(userInstalledAppCategory.getTotal()) : userInstalledAppCategory.getTotal() != null) {
            return false;
        } else if (loanCnt != null ? !loanCnt.equals(userInstalledAppCategory.getLoanCnt()) : userInstalledAppCategory.getLoanCnt() != null) {
            return false;
        } else if (investCnt != null ? !investCnt.equals(userInstalledAppCategory.getInvestCnt()) : userInstalledAppCategory.getInvestCnt() != null) {
            return false;
        } else if (bankCnt != null ? !bankCnt.equals(userInstalledAppCategory.getBankCnt()) : userInstalledAppCategory.getBankCnt() != null) {
            return false;
        } else if (betCnt != null ? !betCnt.equals(userInstalledAppCategory.getBetCnt()) : userInstalledAppCategory.getBetCnt() != null) {
            return false;
        } else if (creditCnt != null ? !creditCnt.equals(userInstalledAppCategory.getCreditCnt()) : userInstalledAppCategory.getCreditCnt() != null) {
            return false;
        } else if (welfareCnt != null ? !welfareCnt.equals(userInstalledAppCategory.getWelfareCnt()) : userInstalledAppCategory.getWelfareCnt() != null) {
            return false;
        } else if (lifeCnt != null ? !lifeCnt.equals(userInstalledAppCategory.getLifeCnt()) : userInstalledAppCategory.getLifeCnt() != null) {
            return false;
        } else if (sensitiveCnt != null ? !sensitiveCnt.equals(userInstalledAppCategory.getSensitiveCnt()) : userInstalledAppCategory.getSensitiveCnt() != null) {
            return false;
        } else if (locationCnt != null ? !locationCnt.equals(userInstalledAppCategory.getLocationCnt()) : userInstalledAppCategory.getLocationCnt() != null) {
            return false;
        } else if (gameCnt != null ? !gameCnt.equals(userInstalledAppCategory.getGameCnt()) : userInstalledAppCategory.getGameCnt() != null) {
            return false;
        }
        return true;
    }
}
