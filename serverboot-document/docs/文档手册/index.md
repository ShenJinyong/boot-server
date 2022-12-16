# 文档手册

## Vitepress

在线文档采用当前比较流行的`Vitepress`

`VitePress`中文网地址：`https://vitejs.cn/vitepress/`

## 快速开始

> 按住`win+R`键，输入cmd，按下回车，进入控制台

 创建目录`ServerBootDocument`

```sh
mkdir ServerBootDocument
```

进入目录`ServerBootDocument`

```sh
cd ServerBootDocument
```

全局安装yarn源

```sh
npm install -g yarn
```

初始化

```sh
yarn init
```

本地安装 `VitePress`

```sh
yarn add --dev vitepress
```

创建文档文件夹，必须是`docs`

```sh
mkdir docs
```

进入文档文件夹

```sh
cd docs
```

创建第一篇文档，输出到`index.md`

```sh
echo # Hello VitePress > index.md
```

在 `package.json`添加一些`script`

```json
{
  "scripts": {
    "docs:dev": "vitepress dev docs",
    "docs:build": "vitepress build docs",
    "docs:serve": "vitepress serve docs"
  }
}
```

在本地服务器上启动文档站点

```sh
yarn docs:dev
```

访问：`http://localhost:5173/ServerBootDocument/`

## Github部署

创建`github`仓库`ServerBootDocument`

编辑部署脚本`ServerBootDocument/deploy.sh`

```sh
#!/usr/bin/env sh

# 忽略错误
set -e

# 构建
npm run docs:build

# 进入待发布的目录
cd docs/.vitepress/dist

# 如果是发布到自定义域名
# echo 'www.example.com' > CNAME

git init
git add -A
git commit -m 'deploy'

# 如果部署到 https://<USERNAME>.github.io
# git push -f git@github.com:<USERNAME>/<USERNAME>.github.io.git master

# 如果是部署到 https://<USERNAME>.github.io/<REPO>
git push -f git@github.com:ShenJinyong/ServerBootDocument.git master:gh-pages

cd -
```

双击运行部署脚本`deploy.sh`

点击`settings`，点击`Code and automation`下面的`Pages`

`Build and deployment`下面的`Source`选择`Deploy from a branch`，`Branch`选择`gh-pages/root`，点击`Save`保存

修改文档内容，再次运行部署文档，点击`settings`，点击`Code and automation`下面的`Pages`，在`GitHub Pages`即可以看到`Your site is live at https://shenjinyong.github.io/ServerBootDocument/`，点击`Visit site`就可以访问。

::: tip 说明
关于资源加载找不到的问题处理，需要在`ServerBootDocument/docs/.vitepress/config.js`种添加`base`配置

:::

```sh
module.exports = {
  title: '在线文档', //标题
  base: '/ServerBootDocument/',//github仓库名
  }
}
```

## 静态资源处理

> 公共资源

把公共资源存放在`ServerBootDocument/docs/public`，在打包的时候将原样复制到`dist`目录的根目录

::: tip 注意
应该使用根绝对路径引用放置在`public`文件夹中的文件。

例如，文件`public/icon.png`在源代码中应该始终作为`/icon.png`被引用。

:::

> 基础 URL

对于`markdown`里面的单个资源的使用建议使用相对路径引用即可。

## MarkDown扩展

> 自定义容器

```md
::: tip 提示
This is a tip
:::

::: warning 警告
This is a warning
:::

::: danger 危险
This is a dangerous warning
:::
```

