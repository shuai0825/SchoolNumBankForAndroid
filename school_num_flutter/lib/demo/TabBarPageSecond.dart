import 'package:flutter/material.dart';

class TabBarPageSecond extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _TabBarPageSecond();
}

class _TabBarPageSecond extends State<TabBarPageSecond>
    with AutomaticKeepAliveClientMixin {
  final _suggestions = <String>[];
  final _biggerFont = const TextStyle(fontSize: 18.0);

  @override
  bool get wantKeepAlive => true;

  @override
  Widget build(BuildContext context) {
    super.build(context);
    return _buildSuggestions();
  }

  Widget _buildSuggestions() {
    return new ListView.builder(
        padding: new EdgeInsets.all(16.0), itemBuilder: (context, i) {
          if(i.isOdd) return new Divider();
          final index= i ~/ 2;
          if(index>=_suggestions.length){
            _suggestions.addAll(generateWordPairs());
          }
          return _buildRow(_suggestions[index]);
    });
  }
  generateWordPairs() {
    return [
      "aaa",
      "bbbb",
      "ccc",
      "4444444",
      "11111",
      "222222",
      "3333333",
      "4444444",
      "11111",
      "222222",
      "3333333",
      "4444444",
      "11111",
      "222222",
      "3333333",
      "4444444"
    ];
  }
  Widget _buildRow(String pair) {
    return new ListTile(
      title: new Text(
        pair,
        style: _biggerFont,
      ),
    );
  }
}
