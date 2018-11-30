import 'package:flutter/material.dart';
import 'package:flutter_webview_plugin/flutter_webview_plugin.dart';

class ArticleWeb extends StatefulWidget {
  String _item;

  ArticleWeb(this._item);

  @override
  State<StatefulWidget> createState() => ArticleWebState(_item);
}

class ArticleWebState extends State<ArticleWeb> {
  String _item;

  ArticleWebState(this._item);

  @override
  void initState() {
    super.initState();
  }

  @override
  void dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new WebviewScaffold(
        url: _item,
        withJavascript: true,
        withZoom: true,
        appBar: new AppBar(
          title: new Text("Widget webview"),
        ));
    ;
  }
}
