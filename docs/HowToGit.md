# 如何使用Git
JunJian from 2014.07.20

## 一个原则吧

	很多东西我们都可以搜到很多资料，但是我们觉得还是有必要ReWrite一遍，至少两个理由来这么做，其一是为了简化信息，让信息更加直接实用；其二是为了信息完整和统一，因为我们不能排除在开发过程中有新朋友加入，而这是我们所乐见的。

## 最概括的概念

	Git是一个代码管理工具，是Linux之父Linus Torvalds为了全球性的linux协同开发而编写的程序，所以它适合我们，因为我们可能都不在一个城市。而GitHub就是一个基于git这套方案的代码管理平台（网站）。

## git就是一个程序

	如上所说，git就是一个程序而已，那在我们的电脑怎么安装这个程序呢，这里我们区分三类操作系统做描述（以后都是如此）：

* Windows

    下载安装:http://msysgit.github.io/ 

* Linux(ubuntu)

    sudo apt-get install git

* Mac-OSX 

    自带，如果实用brew重新安装的话：sudo brew install git

## 使用（git这个命令怎么和GitHub打通)
* GitHub上的仓库地址
	
	我们可以先进入GitHub上的WhAreU仓库，在左侧的地方应该能看见类似的clone URL：git@github.com:WhAreU/WhAreU.git的提示，这里的“git@github.com:WhAreU/WhAreU.git”就是我们的仓库的访问地址，一般的格式就是“XXX.git"。

* git clone

	我们知道了WhAreU在GitHub上的地址以后，就可以将其克隆到我们的电脑上，不管那类系统，都可以如下
操作：
 
```
	git clone git@github.com:WhAreU/WhAreU.git
```

如此我们就将在GitHub上代码都复制到了我们电脑的当前目录了。

* git config

	代码复制到本地之后，我们需要来告知一下git我们是谁，我们的邮箱地址是多少，因为我们是要协作的，需要表面身份。类似这么操作：

```
	git config user.name JunJian
	git config user.email junjian_11@163.com
``` 

* git add/commit/

	接下来就可以随意修改在电脑上的代码了，不管怎么修改都不会影响我们在GitHub上的原始代码，除非你需要将修改测试好的代码提交到GitHub上。比如说我们修改了README.md这个文件，然后现在要提交出去：

```
	git add README.md 
	git commit -m "I modify the readme"
```
其中git add是添加需要提交的文件，commit就是一个提交的动作，后面需要跟上必要的message，也就是这次提交的一个描述，还是为了协作。

* git push 

	但是commit之后还是没有更新到GitHub上，因为commit只是让电脑上git收到了你的提交，提交到GitHub的最后一个动作是

```
	git push
```

跑去GitHub上看看，应该能看见你修改的内容了。

* git pull

	但是有一个问题，当你push完了，GitHub上的内容已经变了，但是如果我是在你push之前clone的，那么我的电脑上的代码就不是最新的了，这时候我们肯定不能再去clone一次那么麻烦，只需

```
git pull
```

这样就最新了，所以有两个习惯：1、在开始修改代码之前pull一下，因为可能已经有人做完了你想做的事情；2、在push之前pull一次，因为可能在你修改代码期间又有人push了。

* 用到新的就往下添加吧


## 推荐参考

http://rogerdudler.github.io/git-guide/index.zh.html

http://www.liaoxuefeng.com/wiki/

