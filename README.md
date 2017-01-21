# StrictFP-Back-End

## 开发动态

### 以下为v0版本API的实现情况

- [X] 完成``/api/v0/timeline``
- [X] 完成``/api/v0/user``
- [ ] 完成``/api/v0/article``（带相关文章推荐，个人认为应使用互信息） 
- [ ] 完成 登录 相关API
- [ ] 完成 注册/用户审核 相关API

## 开发须知

1. 代码密集处注意灵活使用空行和注释。
2. 使用小驼峰命名法，形如``thisLine, thisFile``。
3. 遵守Java命名规范，包名全小写，类名首字母大写。
4. 大型重构务必通知 @Eldath 和 @ice1000。
5. 所有API请置于``api``包中，API文档请见这里。
6. 数据库结构图请见[这里](https://github.com/ProgramLeague/strictfp-back-end/blob/master/database.md)。（有建议请提出）
7. 尽可能简化表达式。不要让类似``if (a == true)``的这种垃圾出现。
8. 能不声明变量就不声明变量，火车表达式可读性并不低。
9. 及时``Inspect Code`` (``Analyze`` -\> ``Inspect Code``)，能不留Warning就别留。

**若有相关技术问题，请在Slack组织中讨论。未加入组织的开发者请 @Eldath 或 @ice1000。Slack组织仅用于讨论技术性较强的问题，将会严格控制平均水平及交流内容，非技术问题请勿置于组织中讨论，谢谢合作。**