import 'package:flutter/material.dart';
import 'package:shortcut_badge_plugin/shortcut_badge_plugin.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Plugin example app'),
        ),
        body: SizedBox.expand(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              RaisedButton(
                child: Text('Add badge'),
                onPressed: () {
                  _addBadge();
                },
              ),
              RaisedButton(
                  child: Text('Remove badge'),
                  onPressed: () {
                    _removeBadge();
                  }),
            ],
          ),
        ),
      ),
    );
  }

  void _addBadge() {
    ShortcutBadgePlugin.updateBadgeCount(1);
  }

  void _removeBadge() {
    ShortcutBadgePlugin.removeBadge();
  }
}
