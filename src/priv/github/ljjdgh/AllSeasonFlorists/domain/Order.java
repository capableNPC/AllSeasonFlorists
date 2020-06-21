package priv.github.ljjdgh.AllSeasonFlorists.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private String id; // 订单编号
	private double money;
	private String receiverAddress;
	private String receiverName;
	private String receiverPhone;
	private int paystate; // 订单状态
	private Date ordertime;

	private User user;

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", money=" + money + ", receiverAddress="
				+ receiverAddress + ", receiverName=" + receiverName
				+ ", receiverPhone=" + receiverPhone + ", paystate=" + paystate
				+ ", ordertime=" + ordertime + ", user=" + user
				+ ", orderItems=" + orderItems + "]";
	}

}