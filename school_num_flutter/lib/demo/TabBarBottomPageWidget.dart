import 'package:flutter/material.dart';
import 'package:school_num_flutter/demo/GSYTabBarWidget.dart';
import 'package:school_num_flutter/demo/TabBarPageFirst.dart';
import 'package:school_num_flutter/demo/TabBarPageSecond.dart';

class TabBarBottomPageWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _tabBarBottomPageWidget();
}

class _tabBarBottomPageWidget extends State<TabBarBottomPageWidget> {
  final PageController topPageControl = new PageController();

  final List<String> tab = ["动态", "趋势", "我的"];
  ///渲染Tab 对应页面
  _renderPage() {
    return [
      new TabBarPageFirst(),
      new TabBarPageSecond(),
      new TabBarPageFirst(),
    ];
  }
  ///渲染底部Tab
  _renderTab() {
    List<Widget> list = new List();
    for (int i = 0; i < tab.length; i++) {
      list.add(new FlatButton(
          onPressed: () {
            ///每个 Tabbar 点击时，通过jumpTo 跳转页面
            ///每个页面需要跳转坐标为：当前屏幕大小 * 索引index。
            topPageControl.jumpTo(MediaQuery.of(context).size.width * i);
          },
          child: new Text(
            tab[i],
            maxLines: 1,
          )));
    }
    return list;
  }

  @override
  Widget build(BuildContext context) {
    ///带 Scaffold 的Tabbar页面
    return new GSYTabBarWidget(
        type: GSYTabBarWidget.BOTTOM_TAB,
        ///渲染tab
        tabItems: _renderTab(),
        ///渲染页面
        tabViews: _renderPage(),
        topPageControl: topPageControl,
        backgroundColor: Colors.black45,
        indicatorColor: Colors.white,
        title: new Text("GSYGITHUBFLUTTER"));
  }
}
