# 后台手册

`Vue3`后台模板推荐：`https://tzy1997.com/articles/xi3mpxmd/`

`Vue2`后台模板推荐：`https://tzy1997.com/articles/xi2mpxmd/`

`ServerBootWeb`采用人气比较高的`https://github.com/PanJiaChen/vue-admin-template`

中文文档：`https://panjiachen.github.io/vue-element-admin-site/zh/guide/`

## 目录结构

```sh
├── build                      # 构建相关
├── mock                       # 项目 mock 模拟数据
├── node_modules               # 项目依赖包
├── public                     # 静态资源
│   │── favicon.ico            # favicon图标
│   └── index.html             # html模板
├── src                        # 源代码
│   ├── api                    # 所有请求
│   ├── assets                 # 主题和字体等静态资源
│   ├── components             # 全局公用组件
│   ├── directive              # 全局指令
│   ├── filters                # 全局 filter
│   ├── icons                  # 项目所有 svg icons
│   ├── lang                   # 国际化 language
│   ├── layout                 # 全局 layout
│   ├── router                 # 路由
│   ├── store                  # 全局 store管理
│   ├── styles                 # 全局样式
│   ├── utils                  # 全局公用方法
│   ├── vendor                 # 公用vendor
│   ├── views                  # views 所有页面
│   ├── App.vue                # 入口页面
│   ├── main.js                # 入口文件
│   ├── permission.js          # 权限管理
│   └── settings.js            # 默认设置
├── tests                      # 测试
├── .editorconfig              # 定义和维护编码样式
├── .env.xxx                   # 环境变量配置
├── .eslintignore              # eslint 忽略项
├── .eslintrc.js               # eslint 配置项
├── .gitignore                 # git 忽略项
├── .travis.yml                # 自动化CI配置
├── babel.config.js            # babel-loader 配置
├── jest.config.js             # jest 配置
├── jsconfig.js                # js 配置
├── LICENSE                    # 开源标准
├── package-lock.json          # 打包锁定版本
├── package.json               # package.json
├── postcss.config.js          # postcss 配置
├── README.md				   # 指导说明
└── vue.config.js              # vue-cli 配置
```

## 安装

```sh
# 克隆项目
git clone https://github.com/PanJiaChen/vue-element-admin.git

# 进入项目目录
cd vue-element-admin

# 安装依赖
npm install

# 建议不要用 cnpm 安装 会有各种诡异的bug 可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 本地开发 启动项目
npm run dev
```

