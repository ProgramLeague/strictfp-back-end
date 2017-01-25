# StrictFP-Back-End
[![Build Status](https://travis-ci.org/ProgramLeague/strictfp-back-end.svg?branch=master)](https://travis-ci.org/ProgramLeague/strictfp-back-end)  [![codecov](https://codecov.io/gh/ProgramLeague/strictfp-back-end/branch/master/graph/badge.svg)](https://codecov.io/gh/ProgramLeague/strictfp-back-end)
## 开发动态

### 以下为v0版本API的实现情况

- [X] 完成``/api/v0/timeline``
- [X] 完成``/api/v0/user``
- [ ] 完成``/api/v0/article``（带相关文章推荐，个人认为应使用互信息）
- [X] 完成``/api/v0/misc/heartbeat``
- [ ] 完成``/api/v0/misc/counter``

## 下一步计划

**For V0.0.1 Alpha**

1. 完成``HTTPS``支持；
2. 完成答题系统及其本地I/O功能

## 开发须知

0. 尽可能提供各个功能相应的测试。测试使用JUnit框架。
1. 代码密集处注意灵活使用空行和注释。
2. 使用小驼峰命名法，形如``thisLine, thisFile``。
3. 遵守Java命名规范，包名全小写，类名首字母大写。
4. 大型重构务必通知 [@Eldath](https://github.com/Ray-Eldath) 和 [@ice1000](https://github.com/ice1000)。
5. 所有API请置于``api``包中，API文档请见这里。
6. 数据库结构图请见[这里](https://github.com/ProgramLeague/strictfp-back-end/blob/master/database.md)。（有建议请提出）
7. 尽可能简化表达式。不要让类似``if (a == true)``的这种垃圾出现。
8. 能不声明变量就不声明变量，火车表达式可读性并不低。
9. 及时``Inspect Code`` (``Analyze`` -\> ``Inspect Code``)，能不留Warning就别留。
10. 文件编码请注意，处处UTF-8。
11. 缩进使用Tab，请不要使用空格。代码风格配置文件已经上传，请使用命令行的开发者遵守相关规定。
12. 不要写一个裸的类放在根目录，每个类都应该有他们自己的包。
13. 尽可能保存一些重复性的代码的执行结果。就像动态规划一样，减少重复计算。
14. 代码中可能出错的地方或者重要的信息都给我log出来。

**若有相关技术问题，请在Slack组织中讨论。
未加入组织的开发者请 [@Eldath](https://github.com/Ray-Eldath) 或 [@ice1000](https://github.com/ice1000)。
Slack组织仅用于讨论技术性较强的问题，将会严格控制平均水平及交流内容，非技术问题请勿置于组织中讨论，谢谢合作。**

## 部署步骤

**警告：请严格按照以下部署步骤部署后端服务器，由不规范部署操作造成的错误，后端开发人员不负任何责任！** ~~（对你猜对了，就是在甩锅）~~

1. ``clone``在Travis CI上的最新成功构建的源码；
2. 修改 ``db.QuizFormPool`` 构造方法中的``formInts[]``数组为现存的答题分卷编号；
3. 修改 ``tool.Constant``里``static``块中的``DATABASE_HOST``为当前数据库的IP地址；  
4. 在数据库上正确执行``res/strictfp.sql``中的指令；
5. 测试能否运行``test.main.MainServerTest``和``test.servlet.AllServletTest``方法；
6. 若能，请运行``main.MainServer``以配置服务器；若不能，请向后端开发人员反馈。