module.exports = {
  title: '在线文档', //标题
  base: '/serverboot-document/',//github仓库名
  titleTemplate: "在线文档", //标题模板
  description: '基于SpringBoot开发的轻量级Java快速开发框架在线文档',//描述
  lastUpdated: true, //开启上次更新时间
  themeConfig: {
    //导航栏图标
    logo: '/logo.png',
    //标签页图标
    head:[
      ["link", { rel: "icon", href: "/favicon.ico" }],
    ],
    //导航栏
	  nav: [
		{ text: '首页', link: '/' },
	    { text: '项目介绍', link: '/项目介绍/' },
		{ text: '文档手册', link: '/文档手册/' },
	    { text: '后台手册', link: '/后台手册/' },
	    { text: '后端手册', 
        items: [
          { text: "Swagger", link: "/后端手册/Swagger" },
          { text: "MyBatisPlus", link: "/后端手册/MyBatisPlus" },
          { text: "Commom", link: "/后端手册/common" },
          { text: "Shiro", link: "/后端手册/Shiro" },
          { text: "Nginx", link: "/后端手册/Nginx" },
          { text: "文件上传下载", link: "/后端手册/文件上传下载" }
        ]
      },
    ],
    //社交链接
    socialLinks: [
      { icon: "github", link: "https://github.com/ShenJinyong" },
    ],
    //页脚
    footer: {
      copyright: "Copyright © 2018-present 沈金勇",
    }
  }
}