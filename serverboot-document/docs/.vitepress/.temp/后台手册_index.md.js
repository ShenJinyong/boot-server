import { ssrRenderAttrs, ssrRenderStyle } from "vue/server-renderer";
import { useSSRContext } from "vue";
import { _ as _export_sfc } from "./plugin-vue_export-helper.6ab74304.js";
const __pageData = JSON.parse('{"title":"\u540E\u53F0\u624B\u518C","description":"","frontmatter":{},"headers":[{"level":2,"title":"\u76EE\u5F55\u7ED3\u6784","slug":"\u76EE\u5F55\u7ED3\u6784","link":"#\u76EE\u5F55\u7ED3\u6784","children":[]},{"level":2,"title":"\u5B89\u88C5","slug":"\u5B89\u88C5","link":"#\u5B89\u88C5","children":[]}],"relativePath":"\u540E\u53F0\u624B\u518C/index.md","lastUpdated":1665485001000}');
const _sfc_main = { name: "\u540E\u53F0\u624B\u518C/index.md" };
function _sfc_ssrRender(_ctx, _push, _parent, _attrs, $props, $setup, $data, $options) {
  _push(`<div${ssrRenderAttrs(_attrs)}><h1 id="\u540E\u53F0\u624B\u518C" tabindex="-1">\u540E\u53F0\u624B\u518C <a class="header-anchor" href="#\u540E\u53F0\u624B\u518C" aria-hidden="true">#</a></h1><p><code>Vue3</code>\u540E\u53F0\u6A21\u677F\u63A8\u8350\uFF1A<code>https://tzy1997.com/articles/xi3mpxmd/</code></p><p><code>Vue2</code>\u540E\u53F0\u6A21\u677F\u63A8\u8350\uFF1A<code>https://tzy1997.com/articles/xi2mpxmd/</code></p><p><code>ServerBootWeb</code>\u91C7\u7528\u4EBA\u6C14\u6BD4\u8F83\u9AD8\u7684<code>https://github.com/PanJiaChen/vue-admin-template</code></p><p>\u4E2D\u6587\u6587\u6863\uFF1A<code>https://panjiachen.github.io/vue-element-admin-site/zh/guide/</code></p><h2 id="\u76EE\u5F55\u7ED3\u6784" tabindex="-1">\u76EE\u5F55\u7ED3\u6784 <a class="header-anchor" href="#\u76EE\u5F55\u7ED3\u6784" aria-hidden="true">#</a></h2><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 build                      </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6784\u5EFA\u76F8\u5173</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 mock                       </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u9879\u76EE mock \u6A21\u62DF\u6570\u636E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 node_modules               </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u9879\u76EE\u4F9D\u8D56\u5305</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 public                     </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u9759\u6001\u8D44\u6E90</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u2502\u2500\u2500 favicon.ico            </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># favicon\u56FE\u6807</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u2514\u2500\u2500 index.html             </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># html\u6A21\u677F</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 src                        </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6E90\u4EE3\u7801</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 api                    </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6240\u6709\u8BF7\u6C42</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 assets                 </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u4E3B\u9898\u548C\u5B57\u4F53\u7B49\u9759\u6001\u8D44\u6E90</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 components             </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40\u516C\u7528\u7EC4\u4EF6</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 directive              </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40\u6307\u4EE4</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 filters                </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40 filter</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 icons                  </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u9879\u76EE\u6240\u6709 svg icons</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 lang                   </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u56FD\u9645\u5316 language</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 layout                 </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40 layout</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 router                 </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u8DEF\u7531</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 store                  </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40 store\u7BA1\u7406</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 styles                 </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40\u6837\u5F0F</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 utils                  </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5168\u5C40\u516C\u7528\u65B9\u6CD5</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 vendor                 </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u516C\u7528vendor</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 views                  </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># views \u6240\u6709\u9875\u9762</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 App.vue                </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5165\u53E3\u9875\u9762</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 main.js                </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5165\u53E3\u6587\u4EF6</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u251C\u2500\u2500 permission.js          </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6743\u9650\u7BA1\u7406</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2502   \u2514\u2500\u2500 settings.js            </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u9ED8\u8BA4\u8BBE\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 tests                      </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6D4B\u8BD5</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 .editorconfig              </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5B9A\u4E49\u548C\u7EF4\u62A4\u7F16\u7801\u6837\u5F0F</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 .env.xxx                   </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u73AF\u5883\u53D8\u91CF\u914D\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 .eslintignore              </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># eslint \u5FFD\u7565\u9879</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 .eslintrc.js               </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># eslint \u914D\u7F6E\u9879</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 .gitignore                 </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># git \u5FFD\u7565\u9879</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 .travis.yml                </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u81EA\u52A8\u5316CI\u914D\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 babel.config.js            </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># babel-loader \u914D\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 jest.config.js             </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># jest \u914D\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 jsconfig.js                </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># js \u914D\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 LICENSE                    </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5F00\u6E90\u6807\u51C6</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 package-lock.json          </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6253\u5305\u9501\u5B9A\u7248\u672C</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 package.json               </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># package.json</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 postcss.config.js          </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># postcss \u914D\u7F6E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u251C\u2500\u2500 README.md				   </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u6307\u5BFC\u8BF4\u660E</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">\u2514\u2500\u2500 vue.config.js              </span><span style="${ssrRenderStyle({ "color": "#616E88" })}"># vue-cli \u914D\u7F6E</span></span>
<span class="line"></span></code></pre></div><h2 id="\u5B89\u88C5" tabindex="-1">\u5B89\u88C5 <a class="header-anchor" href="#\u5B89\u88C5" aria-hidden="true">#</a></h2><div class="language-sh"><button class="copy"></button><span class="lang">sh</span><pre><code><span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u514B\u9686\u9879\u76EE</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">git clone https://github.com/PanJiaChen/vue-element-admin.git</span></span>
<span class="line"></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u8FDB\u5165\u9879\u76EE\u76EE\u5F55</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#88C0D0" })}">cd</span><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}"> vue-element-admin</span></span>
<span class="line"></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5B89\u88C5\u4F9D\u8D56</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">npm install</span></span>
<span class="line"></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u5EFA\u8BAE\u4E0D\u8981\u7528 cnpm \u5B89\u88C5 \u4F1A\u6709\u5404\u79CD\u8BE1\u5F02\u7684bug \u53EF\u4EE5\u901A\u8FC7\u5982\u4E0B\u64CD\u4F5C\u89E3\u51B3 npm \u4E0B\u8F7D\u901F\u5EA6\u6162\u7684\u95EE\u9898</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">npm install --registry=https://registry.npm.taobao.org</span></span>
<span class="line"></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#616E88" })}"># \u672C\u5730\u5F00\u53D1 \u542F\u52A8\u9879\u76EE</span></span>
<span class="line"><span style="${ssrRenderStyle({ "color": "#D8DEE9FF" })}">npm run dev</span></span>
<span class="line"></span></code></pre></div></div>`);
}
const _sfc_setup = _sfc_main.setup;
_sfc_main.setup = (props, ctx) => {
  const ssrContext = useSSRContext();
  (ssrContext.modules || (ssrContext.modules = /* @__PURE__ */ new Set())).add("\u540E\u53F0\u624B\u518C/index.md");
  return _sfc_setup ? _sfc_setup(props, ctx) : void 0;
};
const index = /* @__PURE__ */ _export_sfc(_sfc_main, [["ssrRender", _sfc_ssrRender]]);
export {
  __pageData,
  index as default
};
