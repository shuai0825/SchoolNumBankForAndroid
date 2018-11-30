import 'package:flutter/material.dart';
import 'package:school_num_flutter/demo/GSYTabBarWidget.dart';
import 'package:school_num_flutter/demo/TabBarPageFirst.dart';
import 'package:school_num_flutter/demo/TabBarPageSecond.dart';

class TabBarPageWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _TabBarPageWidgetState();
}

class _TabBarPageWidgetState extends State<TabBarPageWidget> {
  final PageController topPageControl = new PageController();

  final List<String> tab = [
    "111",
    "222",
    "333",
    "444",
    "555",
    "666",
    "777",
    "888",
    "999"
  ];
  _renderPage() {
    return  [
      new TabBarPageFirst(),
      new TabBarPageSecond(),
      new TabBarPageFirst(),
      new TabBarPageSecond(),
      new TabBarPageFirst(),
      new TabBarPageSecond(),
      new TabBarPageSecond(),
      new TabBarPageSecond(),
      new TabBarPageFirst(),
    ];
  }
  _renderTab() {
    List<Widget> list = new List();
    for (int i = 0; i < tab.length; i++) {
      list.add(new FlatButton(onPressed: () {
        topPageControl.jumpTo(MediaQuery
            .of(context)
            .size
            .width * i);
      }, child: new Text(
        tab[i],
        maxLines: 1,
      )));
    }
    return list;
  }

  @override
  Widget build(BuildContext context) {
    return  new GSYTabBarWidget(
        type: GSYTabBarWidget.TOP_TAB,
        tabItems: _renderTab(),
        tabViews: _renderPage(),
        topPageControl: topPageControl,
        backgroundColor: Colors.lightBlue,
        indicatorColor: Colors.white,
        title: new Text("Test"));
  }
}


