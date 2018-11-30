import 'dart:async';
import 'dart:io';

import 'package:flutter/material.dart';


class MyDrawerPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => MyDrawerPageState();
}

class MyDrawerPageState extends State<MyDrawerPage> {
  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: Column(
        children: <Widget>[
          Container(
              height: 200.0,
              color: Theme.of(context).primaryColor,
              child: Stack(
                children: <Widget>[
                  Center(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: <Widget>[
                        SizedBox(
                          width: 80.0,
                          height: 80.0,
                          child: CircleAvatar(
                            backgroundImage:
                                AssetImage("images/icon_head_default.png"),
                          ),
                        ),
                        Padding(
                          padding: EdgeInsets.only(top: 12.0),
                          child: Text(
                            '登录',
                            style:
                                TextStyle(color: Colors.white, fontSize: 18.0),
                          ),
                        ),
                      ],
                    ),
                  ),
                  Align(
                    alignment: Alignment.bottomRight,
                    child: FlatButton(
                        onPressed: null,
                        child: Text(
                          '前问登录',
                          style: TextStyle(color: Colors.white, fontSize: 14.0),
                        )),
                  )
                ],
              )),
          Expanded(
            child: ListView(
              children: <Widget>[
                ListTile(
                  title: Text('我喜欢的'),
                  trailing: Icon(Icons.navigate_next),
                ),
                Divider(),
                ListTile(
                  onTap: getImage,
                  title: Text('关于'),
                  trailing: Icon(Icons.navigate_next),
                )
              ],
            ),
          )
        ],
      ),
    );
  }
  File _image;
  Future getImage() async {
//    var image = await ImagePicker.pickImage(source: ImageSource.camera);
//
//    setState(() {
//      _image = image;
//    });
  }
}
