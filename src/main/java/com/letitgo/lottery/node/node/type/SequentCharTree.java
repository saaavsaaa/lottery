package com.letitgo.lottery.node.node.type;

/**
 * Created by aaa on 2017/4/16.
 * 首字符的空格子节点下挂对应的SequentCharTree，在对应树的节点中查出具体DocNode类型
 * 可以在当前包中完成
 */
final class SequentCharTree {
    // TODO: 2017/4/16 用反射动态实现
    // region A
    //a : 空格 b c d p r s u
    /*              p
    *           c       s
    *       b      d  r(e d)     u
    * */
    CharNode buildA() {
        CharNode bbr = new SequentUniqueCharsNode('b', null, null, "AbbrNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'b', 'r'};
                return cs;
            }
        };
        CharNode ddress = new SequentUniqueCharsNode('d', null, null, "AddressNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'d', 'r', 'e', 's', 's'};
                return cs;
            }
        };
        CharNode cronym = new SequentUniqueCharsNode('c', bbr, ddress, "AcronymNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'r', 'o', 'n', 'y', 'm'};
                return cs;
            }
        };

        CharNode ea = new SequentUniqueCharsNode('e', null, null, "AreaNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'a'};
                return cs;
            }
        };
        CharNode ticle = new SequentUniqueCharsNode('t', null, null, "ArticlesNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'i', 'c', 'l', 'e'};
                return cs;
            }
        };
        CharNode r = new CharTreeNode('r', ea, ticle);

        CharNode udio = new SequentUniqueCharsNode('d', null, null, "AudioNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'u', 'd', 'i', 'o'};
                return cs;
            }
        };
        CharNode side = new SequentUniqueCharsNode('d', r, udio, "AsideNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'s' ,'i', 'd', 'e'};
                return cs;
            }
        };

        CharNode pplet = new SequentUniqueCharsNode('p', cronym, side, "AppletNode") {
            @Override
            char[] SequentChars() {
                char[] cs = {'p', 'l', 'e', 't'};
                return cs;
            }
        };
        CharNode space = SequentCharTree.createSpaceSequentCharNode("ANode");
        CharNode a = new CharTreeNode('a', space, pplet);
        return a;
    }
    // endregion

    private static CharNode createSpaceSequentCharNode(final String docType){
        return new SequentCharNode(' ', null, null, docType);
    }
}

// region 各种元素
    /*<!-->
    <!DOCTYPE>
    <a>
    <abbr>
    <acronym>
    <address>
    <applet>
    <area>
    <article>
    <aside>
    <audio>
    <b>
    <base>
    <basefont>
    <bdi>
    <bdo>
    <big>
    <blockquote>
    <body>
    <br>
    <button>
    <canvas>
    <caption>
    <center>
    <cite>
    <code>
    <col>
    <colgroup>
    <command>
    <datalist>
    <dd>
    <del>
    <details>
    <dfn>
    <dialog>
    <dir>
    <div>
    <dl>
    <dt>
    <em>
    <embed>
    <fieldset>
    <figcaption>
    <figure>
    <font>
    <footer>
    <form>
    <frame>
    <frameset>
    <h1> - <h6>
    <head>
    <header>
    <hr>
    <html>
    <i>
    <iframe>
    <img>
    <input>
    <ins>
    <kbd>
    <keygen>
    <label>
    <legend>
    <li>
    <link>
    <main>
    <map>
    <mark>
    <menu>
    <menuitem>
    <meta>
    <meter>
    <nav>
    <noframes>
    <noscript>
    <object>
    <ol>
    <optgroup>
    <option>
    <output>
    <p>
    <param>
    <pre>
    <progress>
    <q>
    <rp>
    <rt>
    <ruby>
    <s>
    <samp>
    <script>
    <section>
    <select>
    <small>
    <source>
    <span>
    <strike>
    <strong>
    <style>
    <sub>
    <summary>
    <sup>
    <table>
    <tbody>
    <td>
    <textarea>
    <tfoot>
    <th>
    <thead>
    <time>
    <title>
    <tr>
    <track>
    <tt>
    <u>
    <ul>
    <var>
    <video>
    <wbr>*/
// endregion