import 'dart:async';
import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:school_num_flutter/demo/MyTopTabWidget.dart';
import 'package:school_num_flutter/demo/TabBarBottomPageWidget.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:image_picker/image_picker.dart';

void main() => runApp(_widgetForRoute(window.defaultRouteName));

Widget _widgetForRoute(String route) {
  switch (route) {
    case 'route1':
      return new MyApp();
    default:
      return new MyApp();
  }
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
        //便利标签，包含很多小组件
        title: 'demo',
        theme: new ThemeData(primarySwatch: Colors.red),
        home: new MainPage());
  }
}

class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => MainPageState();
}

class MainPageState extends State<MainPage> {
  static const counterPlugin = const EventChannel('com.jzhu.counter/plugin');
  static const jumpPlugin = const MethodChannel('com.jzhu.jump/plugin');
  StreamSubscription _subscription = null;
  var message = '12';


  @override
  void initState() {
    //开启监听
    if (_subscription == null) {
      _subscription = counterPlugin
          .receiveBroadcastStream()
          .listen(_onEvent, onError: _onError);
    }
    super.initState();
  }

  @override
  void dispose() {
    //取消监听
    if (_subscription != null) {
      _subscription.cancel();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      //布局结构基本实现，appbar：应用顶部；body，主要内容；bottomNavigationBar ：底部导航;draw:侧滑
      appBar: new AppBar(
        title: new Text('title'),
      ),
      body: new Column(
        //column：竖直布局；
        children: <Widget>[
          new FlatButton(
              //扁平化按钮
              color: Colors.red, //设置点击，颜色有效
              onPressed: () {
                Navigator.push(
                    //跳转
                    context,
                    new MaterialPageRoute(
                        //管理具有堆栈规则的一组子小部件
                        builder: (context) => new MyTopTabWidget()));
              },
              child: new Text("顶部标题栏")),
          new FlatButton(
              color: Colors.red,
              onPressed: () {
//                Navigator.push(
//                    context,
//                    new MaterialPageRoute(
//                        builder: (context) => new TabBarBottomPageWidget()));
               // _incrementCounter();
                getImage();
              },
              child: new Text(message))
        ],
      ),
    );
  }
  _incrementCounter() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    int counter = (prefs.getInt('counter') ?? 0) + 1;
    print('Pressed $counter times.');
    print(prefs.getString('data'));
    print(prefs.hashCode);
    prefs.setInt('counter', counter);
  }
  Future getImage() async {
    var image = await ImagePicker.pickImage(source: ImageSource.camera);

  }

  void _onEvent(Object event) {
    setState(() {
      message = event.toString();
      print("ChannelPage: $event");
    });
  }

  void _onError(Object error) {
    setState(() {
      print(error);
    });
  }
}
