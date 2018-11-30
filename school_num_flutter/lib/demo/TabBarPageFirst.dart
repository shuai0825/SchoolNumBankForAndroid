import 'dart:async';

import 'package:flutter/material.dart';
import 'package:school_num_flutter/common/NetUtils.dart';
import 'package:school_num_flutter/common/Urls.dart';
import 'package:school_num_flutter/widget/ArticleWeb.dart';

class TabBarPageFirst extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _TabBarPageFirstState();
}

//AutomaticKeepAliveClientMixin.,切换后保留tab的状态，类似android的viewpage的保存功能
class _TabBarPageFirstState extends State<TabBarPageFirst>
    with AutomaticKeepAliveClientMixin {
  //列表滑动监听
  ScrollController _scrollController = ScrollController();

  /// 给Snack用的。
  final GlobalKey<ScaffoldState> _scaffoldState = GlobalKey();

  /// 获取到的文章列表数据集合。给ListView构建Item时使用。
  List _articleData = List();

  /// 文章总条数，用来做加载更多的判断用的。
  var _totalCount;

  /// 当前的页面，这个接口是从0开始的。
  var _curPager = 0;

  /// 标志当前在请求中。
  var _isRequesting = false;

  /// 下拉刷新动作，这里需要看下文档
  Future<Null> _refresh() async {
    //  getBannerData();
    getArticleData(false);
    return null;
  }

  @override
  bool get wantKeepAlive => true;

  @override
  void initState() {
    // _articleData = ["1", "2", "3", "4"];
    _scrollController.addListener(() {
      if (_scrollController.position.maxScrollExtent ==
              _scrollController.position.pixels &&
          _articleData.length < _totalCount &&
          !_isRequesting) {
        // 这个时候触发加载更多
        getArticleData(true);
      }
    });
    _refresh();
    super.initState();
  }

  @override
  Widget build(BuildContext context) => Scaffold(
        key: _scaffoldState,
        body: _articleData.length == 0
            ? Center(
                child: CircularProgressIndicator(
                  valueColor:
                      AlwaysStoppedAnimation(Theme.of(context).primaryColor),
                ),
              )
            : RefreshIndicator(
                child: ListView.builder(
                  itemBuilder: (context, index) => getListViewItemWidget(index),
                  itemCount: _articleData.length,
                  controller: _scrollController,
                ),
                onRefresh: _refresh,
              ),
      );

  /**
   * 填充条目
   */
  getListViewItemWidget(int index) {
    var item = _articleData[index];
    return Card(
      margin: EdgeInsets.all(8.0),
      elevation: 2.0,
      child: InkWell(
        onTap: (){
          Navigator.of(context).push(MaterialPageRoute(builder: (context)=> ArticleWeb(item['link'])));
        },
        child: Padding(
          padding: EdgeInsets.all(12.0),
          child: new Row(children: <Widget>[
            new Image.network(
              item['envelopePic'],
              width: 100.0,
              height: 80.0,
              fit: BoxFit.fill,
            ),
            Expanded(
              child: new Column(
                  textDirection: TextDirection.rtl,
                  children: <Widget>[
                    Text(
                      item['superChapterName'],
                    ),
                    Text(
                      item['title'],
                    ),
                  ]),
            ),
          ]),
        ),
      ),
    );
  }

// 获取文章列表的数据
  Future getArticleData(bool isLoadMore) async {
    if (!isLoadMore) {
      _curPager = 0;
    }
    // 拼接url
    var articleUrl = "${Urls.ARTICLE_LIST}$_curPager/json";
    // 开始请求  来一个请求中的值吧。
    setState(() {
      _isRequesting = true;
    });

    NetUtils.getDatas(articleUrl, new Map()).then((response) {
      // Map<String, dynamic> resultMap = jsonDecode(response);
      //print(response['resultDesc']);
      _isRequesting = false;
      var data = response['data'];
      if (data != null) {
        setState(() {
          _totalCount = data["total"];
          // 要加的列表数据
          if (!isLoadMore) {
            _articleData = data["datas"];
          } else {
            _articleData.addAll(data["datas"]);
          }
          _curPager++;
        });
        // 如果是加载成功再提示一下吧。
        if (isLoadMore) {
          _scaffoldState.currentState.showSnackBar(
              SnackBar(content: Text("新增了${data["datas"].length}条数据")));
        }
      } else {
        Scaffold.of(context)
            .showSnackBar(new SnackBar(content: new Text('这是一个SnackBar')));
      }
    });
  }
}
