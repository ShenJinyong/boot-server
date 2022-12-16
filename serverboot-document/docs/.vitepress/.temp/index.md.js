import { ssrRenderAttrs } from "vue/server-renderer";
import { useSSRContext } from "vue";
import { _ as _export_sfc } from "./plugin-vue_export-helper.6ab74304.js";
const __pageData = JSON.parse('{"title":"","description":"","frontmatter":{"layout":"home","hero":{"name":"ServerBoot","tagline":"\u57FA\u4E8ESpringBoot\u5F00\u53D1\u7684\u8F7B\u91CF\u7EA7Java\u5FEB\u901F\u5F00\u53D1\u6846\u67B6","actions":[{"theme":"alt","text":"\u6587\u6863\u4ED3\u5E93\u5730\u5740","link":"https://github.com/ShenJinyong/ServerBootDocument.git"},{"theme":"alt","text":"\u540E\u7AEF\u4ED3\u5E93\u5730\u5740","link":"https://github.com/ShenJinyong/ServerBoot.git"},{"theme":"alt","text":"\u540E\u53F0\u4ED3\u5E93\u5730\u5740","link":"https://github.com/ShenJinyong/ServerBootUI.git"},{"theme":"alt","text":"\u524D\u53F0\u6587\u6863\u5730\u5740","link":"https://github.com/ShenJinyong/ServerBootWeb.git"}]},"features":[{"icon":null,"title":"SpringBoot \u542F\u52A8\u5668","details":"\u7B80\u5316\u5F00\u53D1\uFF0C\u7EA6\u5B9A\u5927\u4E8E\u914D\u7F6E"},{"icon":null,"title":"Shiro \u5B89\u5168\u6846\u67B6","details":"\u8BA4\u8BC1\u6388\u6743\u3001\u52A0\u5BC6\u89E3\u5BC6\u3001\u4F1A\u8BDD\u7BA1\u7406\u3001Web\u96C6\u6210\u548C Java API \u96C6\u6210"},{"icon":null,"title":"MyBatisPlus \u589E\u5F3A\u5DE5\u5177","details":"\u4E3A\u7B80\u5316\u5F00\u53D1\u800C\u751F\uFF0C\u96C6\u6210\u5206\u9875\u63D2\u4EF6\u3001\u4E50\u89C2\u9501\u3001\u903B\u8F91\u5220\u9664\u548C\u4EE3\u7801\u81EA\u52A8\u751F\u6210\u5668"},{"icon":null,"title":"Swagger \u5728\u7EBF\u63A5\u53E3\u6587\u6863","details":"Knife4j \u662F\u4E00\u4E2A\u96C6 Swagger2 \u548C OpenAPI3 \u4E3A\u4E00\u4F53\u7684\u589E\u5F3A\u89E3\u51B3\u65B9\u6848"}]},"headers":[],"relativePath":"index.md","lastUpdated":1665224019000}');
const _sfc_main = { name: "index.md" };
function _sfc_ssrRender(_ctx, _push, _parent, _attrs, $props, $setup, $data, $options) {
  _push(`<div${ssrRenderAttrs(_attrs)}></div>`);
}
const _sfc_setup = _sfc_main.setup;
_sfc_main.setup = (props, ctx) => {
  const ssrContext = useSSRContext();
  (ssrContext.modules || (ssrContext.modules = /* @__PURE__ */ new Set())).add("index.md");
  return _sfc_setup ? _sfc_setup(props, ctx) : void 0;
};
const index = /* @__PURE__ */ _export_sfc(_sfc_main, [["ssrRender", _sfc_ssrRender]]);
export {
  __pageData,
  index as default
};
