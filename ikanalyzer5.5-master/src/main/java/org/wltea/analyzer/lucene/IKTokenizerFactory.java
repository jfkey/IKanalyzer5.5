/**
 * Project Name:ikanalyzer
 * File Name:IKTokenizerFactory
 * Package Name:org.wltea.analyzer.lucene
 * Date:2017/12/7 14:08
 * Copyright (c) 2017, ljk@bostech.com.cn All Rights Reserved.
 */
package org.wltea.analyzer.lucene;

import java.util.Map;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

/**
 * TODO
 * @author 刘姜科
 * @since JDK1.7
 * @history 2017/12/7
 */
public class IKTokenizerFactory extends TokenizerFactory {
    private boolean useSmart;

    public boolean useSmart() {
        return this.useSmart;
    }

    public void setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
    }

    public IKTokenizerFactory(Map<String, String> args) {
        super(args);
        String useSmartArg = (String)args.get("useSmart");
        this.setUseSmart(useSmartArg != null?Boolean.parseBoolean(useSmartArg):false);
    }

    public Tokenizer create(AttributeFactory factory) {
        IKTokenizer _IKTokenizer = new IKTokenizer(factory, this.useSmart);
        return _IKTokenizer;
    }
}

