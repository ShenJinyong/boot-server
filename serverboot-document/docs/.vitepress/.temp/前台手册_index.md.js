import { ssrRenderAttrs } from "vue/server-renderer";
import { useSSRContext } from "vue";
import { _ as _export_sfc } from "./plugin-vue_export-helper.6ab74304.js";
const __pageData = JSON.parse('{"title":"\u524D\u53F0\u624B\u518C","description":"","frontmatter":{},"headers":[],"relativePath":"\u524D\u53F0\u624B\u518C/index.md","lastUpdated":1665224019000}');
const _sfc_main = { name: "\u524D\u53F0\u624B\u518C/index.md" };
function _sfc_ssrRender(_ctx, _push, _parent, _attrs, $props, $setup, $data, $options) {
  _push(`<div${ssrRenderAttrs(_attrs)}><h1 id="\u524D\u53F0\u624B\u518C" tabindex="-1">\u524D\u53F0\u624B\u518C <a class="header-anchor" href="#\u524D\u53F0\u624B\u518C" aria-hidden="true">#</a></h1><p>\u656C\u8BF7\u671F\u5F85......</p></div>`);
}
const _sfc_setup = _sfc_main.setup;
_sfc_main.setup = (props, ctx) => {
  const ssrContext = useSSRContext();
  (ssrContext.modules || (ssrContext.modules = /* @__PURE__ */ new Set())).add("\u524D\u53F0\u624B\u518C/index.md");
  return _sfc_setup ? _sfc_setup(props, ctx) : void 0;
};
const index = /* @__PURE__ */ _export_sfc(_sfc_main, [["ssrRender", _sfc_ssrRender]]);
export {
  __pageData,
  index as default
};
