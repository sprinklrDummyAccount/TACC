class BackupThread extends Thread {
    public Fortran() {
        LangName = "Fortran";
        CommentSingle = new HashMap<Integer, String>();
        CommentSingle.put(1, "!");
        CommentSingle.put(2, "Cf2py");
        CommentMulti = new HashMap<String, String>();
        CommentRegexp = new HashMap<Integer, String>();
        CommentRegexp.put(1, "(?mi)^C.*?$");
        CaseKeywords = Global.GESHI_CAPS_NO_CHANGE;
        Quotemarks = new ArrayList<String>();
        Quotemarks.add("\'");
        Quotemarks.add("\"");
        EscapeChar = '\\';
        Keywords = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> KeyStrList1 = new ArrayList<String>();
        KeyStrList1.add("allocate");
        KeyStrList1.add("block");
        KeyStrList1.add("call");
        KeyStrList1.add("case");
        KeyStrList1.add("contains");
        KeyStrList1.add("continue");
        KeyStrList1.add("cycle");
        KeyStrList1.add("deallocate");
        KeyStrList1.add("default");
        KeyStrList1.add("do");
        KeyStrList1.add("else");
        KeyStrList1.add("elseif");
        KeyStrList1.add("elsewhere");
        KeyStrList1.add("end");
        KeyStrList1.add("enddo");
        KeyStrList1.add("endif");
        KeyStrList1.add("endwhere");
        KeyStrList1.add("entry");
        KeyStrList1.add("exit");
        KeyStrList1.add("function");
        KeyStrList1.add("go");
        KeyStrList1.add("goto");
        KeyStrList1.add("if");
        KeyStrList1.add("interface");
        KeyStrList1.add("module");
        KeyStrList1.add("nullify");
        KeyStrList1.add("only");
        KeyStrList1.add("operator");
        KeyStrList1.add("procedure");
        KeyStrList1.add("program");
        KeyStrList1.add("recursive");
        KeyStrList1.add("return");
        KeyStrList1.add("select");
        KeyStrList1.add("stop");
        KeyStrList1.add("subroutine");
        KeyStrList1.add("then");
        KeyStrList1.add("to");
        KeyStrList1.add("where");
        KeyStrList1.add("while");
        KeyStrList1.add("access");
        KeyStrList1.add("action");
        KeyStrList1.add("advance");
        KeyStrList1.add("blank");
        KeyStrList1.add("blocksize");
        KeyStrList1.add("carriagecontrol");
        KeyStrList1.add("delim");
        KeyStrList1.add("direct");
        KeyStrList1.add("eor");
        KeyStrList1.add("err");
        KeyStrList1.add("exist");
        KeyStrList1.add("file");
        KeyStrList1.add("flen");
        KeyStrList1.add("fmt");
        KeyStrList1.add("form");
        KeyStrList1.add("formatted");
        KeyStrList1.add("iostat");
        KeyStrList1.add("name");
        KeyStrList1.add("named");
        KeyStrList1.add("nextrec");
        KeyStrList1.add("nml");
        KeyStrList1.add("number");
        KeyStrList1.add("opened");
        KeyStrList1.add("pad");
        KeyStrList1.add("position");
        KeyStrList1.add("readwrite");
        KeyStrList1.add("recl");
        KeyStrList1.add("sequential");
        KeyStrList1.add("status");
        KeyStrList1.add("unformatted");
        KeyStrList1.add("unit");
        Keywords.put(1, KeyStrList1);
        ArrayList<String> KeyStrList2 = new ArrayList<String>();
        KeyStrList2.add(".AND.");
        KeyStrList2.add(".EQ.");
        KeyStrList2.add(".EQV.");
        KeyStrList2.add(".GE.");
        KeyStrList2.add(".GT.");
        KeyStrList2.add(".LE.");
        KeyStrList2.add(".LT.");
        KeyStrList2.add(".NE.");
        KeyStrList2.add(".NEQV.");
        KeyStrList2.add(".NOT.");
        KeyStrList2.add(".OR.");
        KeyStrList2.add(".TRUE.");
        KeyStrList2.add(".FALSE.");
        Keywords.put(2, KeyStrList2);
        ArrayList<String> KeyStrList3 = new ArrayList<String>();
        KeyStrList3.add("allocatable");
        KeyStrList3.add("character");
        KeyStrList3.add("common");
        KeyStrList3.add("complex");
        KeyStrList3.add("data");
        KeyStrList3.add("dimension");
        KeyStrList3.add("double");
        KeyStrList3.add("equivalence");
        KeyStrList3.add("external");
        KeyStrList3.add("implicit");
        KeyStrList3.add("in");
        KeyStrList3.add("inout");
        KeyStrList3.add("integer");
        KeyStrList3.add("intent");
        KeyStrList3.add("intrinsic");
        KeyStrList3.add("kind");
        KeyStrList3.add("logical");
        KeyStrList3.add("namelist");
        KeyStrList3.add("none");
        KeyStrList3.add("optional");
        KeyStrList3.add("out");
        KeyStrList3.add("parameter");
        KeyStrList3.add("pointer");
        KeyStrList3.add("private");
        KeyStrList3.add("public");
        KeyStrList3.add("real");
        KeyStrList3.add("result");
        KeyStrList3.add("save");
        KeyStrList3.add("sequence");
        KeyStrList3.add("target");
        KeyStrList3.add("type");
        KeyStrList3.add("use");
        Keywords.put(3, KeyStrList3);
        ArrayList<String> KeyStrList4 = new ArrayList<String>();
        KeyStrList4.add("abs");
        KeyStrList4.add("achar");
        KeyStrList4.add("acos");
        KeyStrList4.add("adjustl");
        KeyStrList4.add("adjustr");
        KeyStrList4.add("aimag");
        KeyStrList4.add("aint");
        KeyStrList4.add("all");
        KeyStrList4.add("allocated");
        KeyStrList4.add("anint");
        KeyStrList4.add("any");
        KeyStrList4.add("asin");
        KeyStrList4.add("atan");
        KeyStrList4.add("atan2");
        KeyStrList4.add("bit_size");
        KeyStrList4.add("break");
        KeyStrList4.add("btest");
        KeyStrList4.add("carg");
        KeyStrList4.add("ceiling");
        KeyStrList4.add("char");
        KeyStrList4.add("cmplx");
        KeyStrList4.add("conjg");
        KeyStrList4.add("cos");
        KeyStrList4.add("cosh");
        KeyStrList4.add("cpu_time");
        KeyStrList4.add("count");
        KeyStrList4.add("cshift");
        KeyStrList4.add("date_and_time");
        KeyStrList4.add("dble");
        KeyStrList4.add("digits");
        KeyStrList4.add("dim");
        KeyStrList4.add("dot_product");
        KeyStrList4.add("dproddvchk");
        KeyStrList4.add("eoshift");
        KeyStrList4.add("epsilon");
        KeyStrList4.add("error");
        KeyStrList4.add("exp");
        KeyStrList4.add("exponent");
        KeyStrList4.add("floor");
        KeyStrList4.add("flush");
        KeyStrList4.add("fraction");
        KeyStrList4.add("getcl");
        KeyStrList4.add("huge");
        KeyStrList4.add("iachar");
        KeyStrList4.add("iand");
        KeyStrList4.add("ibclr");
        KeyStrList4.add("ibits");
        KeyStrList4.add("ibset");
        KeyStrList4.add("ichar");
        KeyStrList4.add("ieor");
        KeyStrList4.add("index");
        KeyStrList4.add("int");
        KeyStrList4.add("intrup");
        KeyStrList4.add("invalop");
        KeyStrList4.add("ior");
        KeyStrList4.add("iostat_msg");
        KeyStrList4.add("ishft");
        KeyStrList4.add("ishftc");
        KeyStrList4.add("lbound");
        KeyStrList4.add("len");
        KeyStrList4.add("len_trim");
        KeyStrList4.add("lge");
        KeyStrList4.add("lgt");
        KeyStrList4.add("lle");
        KeyStrList4.add("llt");
        KeyStrList4.add("log");
        KeyStrList4.add("log10");
        KeyStrList4.add("matmul");
        KeyStrList4.add("max");
        KeyStrList4.add("maxexponent");
        KeyStrList4.add("maxloc");
        KeyStrList4.add("maxval");
        KeyStrList4.add("merge");
        KeyStrList4.add("min");
        KeyStrList4.add("minexponent");
        KeyStrList4.add("minloc");
        KeyStrList4.add("minval");
        KeyStrList4.add("mod");
        KeyStrList4.add("modulo");
        KeyStrList4.add("mvbits");
        KeyStrList4.add("nbreak");
        KeyStrList4.add("ndperr");
        KeyStrList4.add("ndpexc");
        KeyStrList4.add("nearest");
        KeyStrList4.add("nint");
        KeyStrList4.add("not");
        KeyStrList4.add("offset");
        KeyStrList4.add("ovefl");
        KeyStrList4.add("pack");
        KeyStrList4.add("precfill");
        KeyStrList4.add("precision");
        KeyStrList4.add("present");
        KeyStrList4.add("product");
        KeyStrList4.add("prompt");
        KeyStrList4.add("radix");
        KeyStrList4.add("random_number");
        KeyStrList4.add("random_seed");
        KeyStrList4.add("range");
        KeyStrList4.add("repeat");
        KeyStrList4.add("reshape");
        KeyStrList4.add("rrspacing");
        KeyStrList4.add("scale");
        KeyStrList4.add("scan");
        KeyStrList4.add("segment");
        KeyStrList4.add("selected_int_kind");
        KeyStrList4.add("selected_real_kind");
        KeyStrList4.add("set_exponent");
        KeyStrList4.add("shape");
        KeyStrList4.add("sign");
        KeyStrList4.add("sin");
        KeyStrList4.add("sinh");
        KeyStrList4.add("size");
        KeyStrList4.add("spacing");
        KeyStrList4.add("spread");
        KeyStrList4.add("sqrt");
        KeyStrList4.add("sumsystem");
        KeyStrList4.add("system_clock");
        KeyStrList4.add("tan");
        KeyStrList4.add("tanh");
        KeyStrList4.add("timer");
        KeyStrList4.add("tiny");
        KeyStrList4.add("transfer");
        KeyStrList4.add("transpose");
        KeyStrList4.add("trim");
        KeyStrList4.add("ubound");
        KeyStrList4.add("undfl");
        KeyStrList4.add("unpack");
        KeyStrList4.add("val");
        KeyStrList4.add("verify");
        Keywords.put(4, KeyStrList4);
        Symbols = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> SymStrList = new ArrayList<String>();
        SymStrList.add("(");
        SymStrList.add(")");
        SymStrList.add("{");
        SymStrList.add("}");
        SymStrList.add("[");
        SymStrList.add("]");
        SymStrList.add("=");
        SymStrList.add("+");
        SymStrList.add("-");
        SymStrList.add("*");
        SymStrList.add("/");
        SymStrList.add("!");
        SymStrList.add("%");
        SymStrList.add("^");
        SymStrList.add("&");
        SymStrList.add(":");
        Symbols.put(Global.JASHI_STUBINDEX, SymStrList);
        CaseSensitive = new HashMap<Integer, Boolean>();
        CaseSensitive.put(Global.GESHI_COMMENTS, true);
        CaseSensitive.put(1, false);
        CaseSensitive.put(2, false);
        CaseSensitive.put(3, false);
        CaseSensitive.put(4, false);
        Styles.Keywords.put(1, "color:#b1b100;");
        Styles.Keywords.put(2, "color:#000000;font-weight:bold;");
        Styles.Keywords.put(3, "color:#000066;");
        Styles.Keywords.put(4, "color:#993333;");
        Styles.Comments.put(1, "color:#666666;font-style:italic;");
        Styles.Comments.put(2, "color:#339933;");
        Styles.Comments.put(Global.MULTI, "color:#808080;font-style:italic;");
        Styles.EscapeChar.put(0, "color:#000099;font-weight:bold;");
        Styles.Brackets.put(0, "color:#009900;");
        Styles.Strings.put(0, "color:#ff0000;");
        Styles.Numbers.put(0, "color:#cc66cc;");
        Styles.Methods.put(1, "color:#202020;");
        Styles.Methods.put(2, "color:#202020;");
        Styles.Symbols.put(0, "color:#339933;");
        URLS = new HashMap<Integer, String>();
        URLS.put(1, "");
        URLS.put(2, "");
        URLS.put(3, "");
        URLS.put(4, "");
        OOLANG = true;
        ObjectSplitters = new HashMap<Integer, String>();
        ObjectSplitters.put(1, ".");
        ObjectSplitters.put(2, "::");
        Regexps = new HashMap<Integer, HashMap<Integer, String>>();
        StrictModeApplies = Global.GESHI_NEVER;
        ScriptDelimiters = new HashMap<Integer, HashMap<String, String>>();
        HighlightStrictBlock = new HashMap<Integer, Boolean>();
    }
}
