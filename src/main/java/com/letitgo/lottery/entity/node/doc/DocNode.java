package com.letitgo.lottery.entity.node.doc;

import com.letitgo.lottery.entity.Attribute;
import com.letitgo.lottery.util.struct.OnlyAddArray;

import java.util.List;

/**
 * Created by aaa on 2017/2/1.
 */
public abstract class DocNode {

    private NodeNotes nodeNotes = null;
    /*
    * when a node has notes, in this case the notes is considered before the node
    * Let's say that it is true, and then confirm whether it is
    * */
    private boolean currentIsNotes = true;

    private int nodeLevel;
    /*
    * Element Type e.g. : div
    * */
//    protected char[] key;
//    protected int keyUsedLength = 0;
    private OnlyAddArray key;

    //root could be like this : <html xmlns="http://www.w3.org/1999/xhtml">
    private List<Attribute> attributes;



    private boolean elementStarted = false;
    private boolean attributeStarted = false;
    private boolean attributeChanged = false;

    protected void initElementType(char c) {
        if (key == null){
            key = new OnlyAddArray();
        }
        key.add(c);
//        key[keyUsedLength] = c;
//        keyUsedLength++;
    }

    protected void initAttributes(char c) {
        //判断key operator value
    }

    private boolean checkNonNode(char c){
        if (c == '!'){
            this.nodeNotes = NodeNotes.createNodeNotes('!');
        }
        if (this.nodeNotes != null){
            return this.nodeNotes.initializing(c);
        }
        return false;
    }

    // TODO: 2017/2/1 Always feel like there's a problem
    private void initNotes(char c){
        if (this.currentIsNotes && checkNonNode(c)){
            this.currentIsNotes = true;
        } else {
            this.nodeNotes = null;
            this.currentIsNotes = false;
        }
    }

    protected void startNewNode(char c){
        initNotes(c);
    }

    protected void endNode(char c){}

    protected void splitBySpace(char c){}

    protected void optValueBunch(char c){
        System.out.println(c);
    }

    public void initializing(char c){
        switch (c)
        {
            case '<' : {
                elementStarted = true;
                attributeStarted = false;
                startNewNode(c);
                break;
            }
            case '>' :{
                elementStarted = false;
                attributeStarted = false;
                // TODO: 2017/2/1 注释和注释之后紧接着的节点合成一个节点
                if (nodeNotes == null) {
//                    this.currentIsNotes
                    endNode(c);
                }
                break;
            }
            case ' ' : {
                if (elementStarted){
                    elementStarted = false;
                    attributeStarted = true;
                    // TODO: 2017/2/1 多个连续空格
                    break;
                }
                splitBySpace(c);
                // TODO: 2017/1/31 *** 想办法区分空格是否是包含在属性段的还是分割属性段的，
                // todo 比如值的引号中间、或者=号前后、注释中间、或者这些情况中空格不只一个
//                attributeChanged = true;
                break;
            }
            case '\"' :
            case '\'' :{
                optValueBunch(c);
                break;
            }
            default :{
                //the element type is a string between '<' and the first space in this element
                if (elementStarted && !attributeStarted){
                    // TODO: 2017/1/31 一个乱开发的网页此处可能未知字符
                    this.initElementType(c);
                }
                if (attributeStarted && !elementStarted){
                    //空格分割多个
                    if (attributeChanged){
                        this.initAttributes(c);
                        attributeChanged = false;
                    }

                }
            }

        }
    }

    public int getNodeLevel() {
        return nodeLevel;
    }

    public void setNodeLevel(int nodeLevel) {
        this.nodeLevel = nodeLevel;
    }
}


/*
            case '\"' :
                break;
            case '\'' :
                break;
            case 0x0A :
            case 0x0D :
            case ' ' :
            case '\t' :

                break;
            case '@' :

            case '-' :

            case '(' :
            case '[' :
            case ')' :
            case ']' :
            case '|' :
            case '/' :
            case '*' :
            case '+' :
            case '=' :
            case ',' :
            case '\\' :  // Unused at the moment
            case '^' :  // Unused at the moment
            case '!' :  // Unused at the moment
            case '$' :
* */
/*
* <!-->
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
<wbr>
* */