/*
 * 使用说明:鉴于我目前的技术,我不能写出如此优秀
 * 可靠的代码,我以全复制进行学习,后期是否修改代码
 * 取决于应用环境.不是我亲手写的代码将保留原代码
 * 作者/组织 的痕迹(其中不包括违反国家法律,与不合适
 * 出现在项目中的注释,其他特殊情况).
 * 
 * 
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package root.root;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranges {

    private final String units;
    private final List<Entry> entries;


    private Ranges(String units, List<Entry> entries) {
        this.units = units;
        this.entries = Collections.unmodifiableList(entries);
    }


public static class Entry {

        private final long start;
        private final long end;


        public Entry(long start, long end) {
            this.start = start;
            this.end = end;
        }


        public long getStart() {
            return start;
        }


        public long getEnd() {
            return end;
        }
    }

    /**
     * Parses a Range header from an HTTP header. 从HTTP头解析范围头
     * 这个包装类中的枚举对象用法我不怎么明白?
     * 没有赋值能用来当参照?
     * 这个类核心功能是HttpParser这个实现的!
     * HttpParser这个包装类不关注!
     * 完全不理解从 HttpParser这个包装器取出数字的目的
     * 这个包装类内部计算的目的
     *
     * @param input a reader over the header text
     *
     * @return a set of ranges parsed from the input, or null if not valid 从输入解析的一组范围，如果无效则为null
     *
     * @throws IOException if there was a problem reading the input
     *
     **/
    public static Ranges parse(StringReader input) throws IOException {

        // Units (required) 单位(必需)
        String units = HttpParser.readToken(input);
        if (units == null || units.length() == 0) {
            return null;
        }

        // Must be followed by '=' 必须后跟'='
        if (HttpParser.skipConstant(input, "=") == SkipResult.NOT_FOUND) {
            return null;
        }

        // Range entries 范围条目
        List<Entry> entries = new ArrayList<>();

        // 这个是一个枚举类,我不知道它是在哪里被赋值的
        SkipResult skipResult;
        do {
            long start = HttpParser.readLong(input);
            // Must be followed by '-'
            // 必须后跟“-”
            if (HttpParser.skipConstant(input, "-") == SkipResult.NOT_FOUND) {
                return null;
            }
            long end = HttpParser.readLong(input);

            if (start == -1 && end == -1) {
                // Invalid range
        	// 无效的范围
                return null;
            }

            entries.add(new Entry(start, end));

            skipResult = HttpParser.skipConstant(input, ",");
            if (skipResult == SkipResult.NOT_FOUND) {
                // Invalid range 无效的范围
                return null;
            }
        } while (skipResult == SkipResult.FOUND);

        // There must be at least one entry
        // 必须至少有一个条目
        if (entries.size() == 0) {
            return null;
        }

        return new Ranges(units, entries);
    }
    
    public List<Entry> getEntries() {
        return entries;
    }

    public String getUnits() {
        return units;
    }

  
}

