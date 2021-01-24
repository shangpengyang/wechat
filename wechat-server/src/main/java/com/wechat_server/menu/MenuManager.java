package com.wechat_server.menu;



/**
 * 菜单管理器
 * @author gaozhiqiang
 */
public class MenuManager
{

	/*
	 * public static void main(String[] args) { // 调用接口获取access_token AccessToken at
	 * = WebChatUtils.getAccessToken(); System.out.println(at.getToken()); if (null
	 * != at) { int result = WebChatUtils.createMenu(getMenu(), at.getToken()); //
	 * 判断菜单创建结果 if (0 == result) System.out.println("菜单创建成功！"); else
	 * System.out.println("菜单创建失败，错误码：" + result); } }
	 */
	/** * 组装菜单数据 * * @return */
	public static Menu getMenu()
	{

		
		/************************************第一列菜单***************************************/
		
//		ViewButton vbtn11 = new ViewButton();
//		vbtn11.setName("新手必读");
//		vbtn11.setType("view");
//		vbtn11.setUrl("http://mp.weixin.qq.com/s?__biz=MzA5NDk4NDA5Ng==&mid=210062014&idx=1&sn=babbf5cda487369cf0ae489719e12a73#rd"); 
		
		CommonButton btn11 = new CommonButton();
		btn11.setName("投资必看");
		btn11.setType("click");
		btn11.setKey("INVESTREAD");
		
		CommonButton btn12 = new CommonButton();
		btn12.setName("绑定加薪猫账户");
		btn12.setType("click");
		btn12.setKey("BINDING");
		
		CommonButton btn13 = new CommonButton();
		btn13.setName("生成我的邀请页");
		btn13.setType("click");
		btn13.setKey("GENINVITE");
		
		ViewButton vbtn14 = new ViewButton();
		vbtn14.setName("我的涨薪计算器");
		vbtn14.setType("view");
		vbtn14.setUrl("http://2j7y481171.wicp.vip/hello"); 
		
		CommonButton btn15 = new CommonButton();
		btn15.setName("联系客服^_^");
		btn15.setType("click");
		btn15.setKey("CSTEL");
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("我的加薪猫");
		mainBtn1.setSub_button(new Button[] {btn11,btn12, btn13, vbtn14, btn15});
		
	    /*********************************第二列菜单**************************************/
		CommonButton btn21 = new CommonButton();
		btn21.setName("点这里，领红包");
		btn21.setType("click");
		btn21.setKey("GETHONGBAO");
		
		ViewButton vbtn22 = new ViewButton();
		vbtn22.setName("微信现金红包规则 ");
		vbtn22.setType("view");     
		vbtn22.setUrl("http://mp.weixin.qq.com/s?__biz=MzA5NDk4NDA5Ng==&mid=209894037&idx=1&sn=5ad856a2d275475c801c6a0604874843#rd"); 
		
		ViewButton vbtn23 = new ViewButton();
		vbtn23.setName("9月邀请争霸赛 ");
		vbtn23.setType("view");     
		vbtn23.setUrl("http://m.jiaxinmore.com/activity/818hero/heroList.html");
		
//		下线
//		ViewButton vbtn23 = new ViewButton();
//		vbtn23.setName("818满万元送大礼");
//		vbtn23.setType("view");
//		vbtn23.setUrl("http://mp.weixin.qq.com/s?__biz=MzA5NDk4NDA5Ng==&mid=210165290&idx=1&sn=9ffe41f5fbc2c0cdc1a2d22bf0186027#rd"); 
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("拿微信红包");
		mainBtn2.setSub_button(new Button[] { btn21, vbtn22,vbtn23});
		
		/************************************第二列菜单****************************************/
		ViewButton vbtn31 = new ViewButton();
		vbtn31.setName("进入加薪猫");
		vbtn31.setType("view");
		//vbtn31.setUrl("http://120.26.138.152/webapp/"); 
		vbtn31.setUrl("http://m.jiaxinmore.com/"); 
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, vbtn31 });
		return menu;
		
	}
}
