package com.example.streamprovider.mode;

import java.util.Date;

/**
 * 创建时间:2019/04/23
 * 创建人:pmc
 * 描述:
 */
public class Order
{
    private String orderNum;
    private String type;
    private int num;
    private Date createAt;

    public Order()
    {
    }

    public Order(String orderNum, String type, int num)
    {
        this.orderNum = orderNum;
        this.type = type;
        this.num = num;
        this.createAt = new Date();
    }

    public String getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public Date getCreateAt()
    {
        return createAt;
    }

    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }
}
