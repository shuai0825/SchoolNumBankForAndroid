//import 'package:flutter/material.dart';
//
////有状态控件
//class TabViewPageUtil extends StatefulWidget {
//  final List<Widget> tabItems;
//  final List<Widget> tabViews; //内容
//  final Color backgroundColor;
//  final Color indicatorColor; //tab选择下划线颜色
//
//  //构造参数
//  TabViewPageUtil({Key key, this.tabItems, this.backgroundColor})
//      : super(key: key);
//
//  @override
//  State<StatefulWidget> createState() => new TabViewPageUtilState(
//      tabItems, backgroundColor, tabViews, indicatorColor);
//}
//
////state用于书写大部分代码
//class TabViewPageUtilState extends State<TabViewPageUtil>
//    with SingleTickerProviderStateMixin {
//  final List<Widget> _tabItems; //标题
//  final List<Widget> _tabViews; //内容
//  final Color _backgroundColor; //标题背景色
//  final Color _indicatorColor; //tab选择下划线颜色
//  final Widget _title;//标题
//
//  //构造方法
//  TabViewPageUtilState(this._tabItems, this._backgroundColor, this._tabViews,
//      this._indicatorColor);
//
//  TabController _tabController; //tab的控制器
//
//  //该类的初始化,初始化控制器
//  @override
//  void initState() {
//    super.initState();
//    _tabController = new TabController(vsync: this, length: _tabItems.length);
//  }
//
//  //页面销毁时，销毁控制器
//  @override
//  void dispose() {
//    _tabController.dispose();
//    super.dispose();
//  }
//
//  @override
//  Widget build(BuildContext context) {
//    return new Scaffold(
//      //drawer: _drawer,侧滑
//      //  floatingActionButton:悬浮按钮
//      appBar: new AppBar(
//        //背景
//        backgroundColor: _backgroundColor,
//        //标题
//        title: _title,
//        //状态栏TabBar
//        bottom: new TabBar(
//          ///每一个tab item，是一个List<Widget>
//          tabs: _tabItems,
//          ///必须有的控制器，与pageView的控制器同步
//          controller: _tabController,
//          //顶部时，tabBar为可以滑动的模式
//          isScrollable: true,
//          ///tab底部选中条颜色
//          indicatorColor: _indicatorColor,
//          //unselectedLabelColor，未选定标签标签的颜色
//          //unselectedLabelStyle，未选择字体颜色
//        ),
//      ),
//    );
//  }
//}
