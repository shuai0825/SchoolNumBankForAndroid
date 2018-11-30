import 'dart:async';

import 'package:dio/dio.dart';
import 'package:school_num_flutter/common/Urls.dart';
class NetUtils {
  static var dio;

  /**
   * 参数初始化
   */
  static Dio getDioInstance() {
    if (dio == null) {
      Options options = new Options(
        baseUrl: Urls.ip,
        connectTimeout: 5000,
        receiveTimeout: 3000,
        responseType: ResponseType.JSON,
      );
      dio = new Dio(options);
    }

    return dio;
  }

  /**
   * get请求，返回值是map
   */
  static Future<Map> getDatas(var url, Map<String, dynamic> params) async {
    print(url);
    var response = await getDioInstance().get(url, data: params);
    return response.data;
  }

  /**
   * post请求，返回值是map
   */
  static Future<Map> postDatas(var url, Map<String, dynamic> params) async {
    var response =
        await getDioInstance().post(url, data: new FormData.from(params));
    return response.data;
  }
}
