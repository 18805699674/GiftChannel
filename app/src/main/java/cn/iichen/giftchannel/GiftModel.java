package cn.iichen.giftchannel;

/**
 * @ProjectName: GiftChannel
 * @Package: cn.iichen.giftchannel
 * @ClassName: GiftModel
 * @Description: java类作用描述
 * @Author: 作者名 qsdiao
 * @CreateDate: 2022/12/28 20:04
 * @UpdateUser: 更新者：qsdiao
 * @UpdateDate: 2022/12/28 20:04
 * @UpdateRemark: 更新说明：Fuck code, go to hell, serious people who maintain it：
 * @Version: 更新说明: 1.0
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * ┃　　　┃   神兽保佑
 * ┃　　　┃   代码无BUG！
 * ┃　　　┗━━━┓
 * ┃　　　　　　　┣┓
 * ┃　　　　　　　┏┛
 * ┗┓┓┏━┳┓┏┛
 * ┃┫┫　┃┫┫
 * ┗┻┛　┗┻┛
 */


public class GiftModel {
    int id;
    String tip;
    int value;
    int num = 1;

    public int getValue() {
        return value;
    }

    public GiftModel(int id, String tip, int value) {
        this.id = id;
        this.tip = tip;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public GiftModel() {
    }

    public GiftModel(int id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
