import 'package:flutter/material.dart';
import 'package:school_num_flutter/demo/TabBarPageFirst.dart';
import 'package:school_num_flutter/demo/TabBarPageSecond.dart';
import 'package:school_num_flutter/widget/MyDrawerPage.dart';

class MyTopTabWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => new TopTabWidget();
}

class TopTabWidget extends State<MyTopTabWidget>
    with SingleTickerProviderStateMixin {
  // 底部导航栏的文字 ， 给appBar 共用一下。
  var _bottomTitles = ["首页", "知识体系", "热门"];

  // 底部导航栏未选中时的图片
  var _bottomIconNor = [
    "images/icon_bottom_main_nor.png",
    "images/icon_bottom_knowledge_nor.png",
    "images/icon_bottom_hot_nor.png"
  ];

  // 底部导航栏选中时的图片
  var _bottomIconChecked = [
    "images/icon_bottom_main_checked.png",
    "images/icon_bottom_knowledge_checked.png",
    "images/icon_bottom_hot_checked.png"
  ];

  // 底部导航栏当前选中的页面
  var _currentBottomIndex = 0;
  TabController _tabController;
  VoidCallback _tabOnChanged;

  // 页面
  var _body;

  @override
  void initState() {
    _tabController = TabController(length: _bottomTitles.length, vsync: this);
    _tabOnChanged = () {
      setState(() {
        _currentBottomIndex = _tabController.index;
      });
    };
    _tabController.addListener(_tabOnChanged);
    super.initState();
  }

  @override
  void dispose() {
    _tabController.removeListener(_tabOnChanged);
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    //IndexedStack继承自Stack，它的作用是显示第index个child，其他child都是不可见的
    _body = TabBarView(
      children: <Widget>[
        TabBarPageFirst(),
        TabBarPageSecond(),
        TabBarPageFirst()
      ],
      controller: _tabController,
    );
    return Scaffold(
      appBar: AppBar(
        title: Text(
          _bottomTitles[_currentBottomIndex],
          style: TextStyle(color: Colors.white),
        ),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.search),
            onPressed: () {},
          )
        ],
        iconTheme: IconThemeData(color: Colors.white),
      ),
      drawer:MyDrawerPage() ,
      body: _body,
      bottomNavigationBar: BottomNavigationBar(
        items: getBottomNavigationBarItems(),
        currentIndex: _currentBottomIndex,
        onTap: (index) {
          setState(() {
            _currentBottomIndex = index;
            _tabController.index = index;
          });
        },
      ),
    );
  }

  //生成单个底部按钮
  getBottomNavigationBarItems() => List.generate(
      _bottomTitles.length,
      (i) => BottomNavigationBarItem(
          icon: getBottomIcon(i), title: getBottomTitle(i)));

  //切换底部文字
  getBottomTitle(int i) => Text(
        _bottomTitles[i],
        style: TextStyle(
            color: _currentBottomIndex == i ? Colors.green : Colors.grey),
      );

  //切换底部图片
  getBottomIcon(int i) => Image.asset(
        getBottomIconPath(i),
        width: 25.0,
        height: 25.0,
      );

  String getBottomIconPath(int i) =>
      _currentBottomIndex == i ? _bottomIconChecked[i] : _bottomIconNor[i];

}
