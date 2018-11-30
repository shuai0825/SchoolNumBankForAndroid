class Urls {
  static const String BASE_URL = "http://www.wanandroid.com/";

  /// 文章列表  后面的参数在使用的时候加吧。
  static const String ARTICLE_LIST = BASE_URL + "article/list/";

  /// 首页banner
  static const String HOME_BANNER_DATA = BASE_URL + "banner/json";

  /// 体系数据
  static const String TREE_DATA = BASE_URL + "tree/json";

  /// 注册
  static const String REGISTER = BASE_URL + "user/register";

  /// 登录
  static const String LOGIN = BASE_URL + "user/login";

  /// 收藏站内文章，还有一个收站外文章没懂是怎么用，先用着这一个了。
  static const String ARTICLE_COLLECT_INNER = BASE_URL + "lg/collect/";

  /// 文章首页列表的取消收藏 http://www.wanandroid.com/lg/uncollect_originId/2333/json
  static const String ARTICLE_UN_COLLECT = BASE_URL + "lg/uncollect_originId/";

  /// 我的收藏列表的文章的取消收藏 http://www.wanandroid.com/lg/uncollect/2805/json
  static const String COLLECT_LIST_UN_COLLECT = BASE_URL + "lg/uncollect/";

  /// 喜欢的文章列表
  static const String COLLECT_ARTICLE_LIST = BASE_URL + "lg/collect/list/";

  /// 知识体系下的文章
  static const String KNOWLEDGE_PROJECT_LIST = BASE_URL + "article/list/";

  /// 搜索文章 http://www.wanandroid.com/article/query/0/json   post  参数 k 为关键字
  static const String SEARCH_ARTICLE_LIST = BASE_URL + "article/query/";

  /// 搜索热词 http://www.wanandroid.com/hotkey/json
  static const String HOT_SEARCH_LIST = BASE_URL + "hotkey/json";

  /// 常用网站 http://www.wanandroid.com/friend/json
  static const String HOT_WEBSITE_LIST = BASE_URL + "friend/json";

  // 测试联网
  static const String base = "http://210.76.3.100:"; //ip
  static const String ip = base + "8893"; //端口号
  static const String key = ip + "/app/"; //测试外网
  static const String login = key + "member/login"; //post登录 phone\pwd
  static const String getNewVersion =
      key + "appVersion/getNewVersion"; //get版本更新
   static final String queryGoods = key + "baseGoods/queryGoods";//get,page/pageSize/shopId
   static final String articleList ="www.wanandroid.com/article/list/";//get,page/pageSize/shopId
}
