# StrictFP-Back-End

## 开发须知
0. 代码密集处注意灵活使用空行。
1. 使用小驼峰命名法，形如`` thisLine, thisFile ``。
2. 遵守Java命名规范，包名全小写，类名首字母大写。
3. 大型重构务必通知 @Eldath 和 @ice1000。
4. 所有API请置于``api``包中，API文档请见[这里](https://github.com/ProgramLeague/strictfp/blob/hexo/source/_posts/apis_def.md)。
5. 数据库结构图请见[这里](https://www.processon.com/view/link/587ef0a9e4b049e7959d88d5)。（个人认为灰常不行，有建议请提出）
6. 尽可能简化表达式。不要让类似if (a == true)的这种垃圾出现。
7. 能不声明变量就不声明变量。火车表达式可读性并不低。