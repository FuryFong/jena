/*
 * (c) Copyright 2001-2003, Hewlett-Packard Company, all rights reserved.
 * [See end of file]
 */

package com.hp.hpl.jena.rdql.parser;

import com.hp.hpl.jena.rdql.* ;
import java.io.PrintWriter;

/* This file is automatically generated - do not edit.
 * Arguments: 
 *       Name = BitOr
 *       Operator = |
 *       Print Name = bitor
 *       Template = ExprNumericBLANK2-int.java
 */

/** 
 * @author: Automatically generated class: Operator: BitOr
 * @version: $Id: Q_BitOr.java,v 1.3 2003-06-13 17:04:28 andy_seaborne Exp $
 */

class Q_BitOr extends SimpleNode implements Expr, ExprNumeric
{
    Expr left ;
    Expr right ;

    private String printName = "bitor" ;
    private String opSymbol = "|" ;

    Q_BitOr(int id) { super(id); }

    Q_BitOr(RDQLParser p, int id) { super(p, id); }

    public Value eval(Query q, ResultBinding env)
    {
        //int n = jjtGetNumChildren() ;

        Value x = left.eval(q, env) ;
        Value y = right.eval(q, env) ;

        if ( ! x.isNumber() )
            throw new EvalTypeException("Q_BitOr: Wanted a number: "+x) ;
        if ( ! y.isNumber() )
            throw new EvalTypeException("Q_BitOr: Wanted a number: "+y) ;
        
        Settable result ;
        if ( x instanceof Settable )
            result = (Settable)x ;
        else if ( y instanceof Settable )
            result = (Settable)y ;
        else
            result = new WorkingVar() ;

        if ( x.isInt() && y.isInt() )
            result.setInt(x.getInt() | y.getInt()) ;
        else
            throw new EvalTypeException("Q_BitOr: one or both operands are doubles: "+x+" | "+y) ;

        return result ;
    }

    // Could do some checking that children are numeric
    // Could collapse constant expressions

    public void jjtClose()
    {
        int n = jjtGetNumChildren() ;
        if ( n != 2 )
            throw new QueryException("Q_BitOr: Wrong number of children: "+n) ;
        
        left = (Expr)jjtGetChild(0) ;
        right = (Expr)jjtGetChild(1) ;
    }

    public String asInfixString()
    {
        return QueryPrintUtils.asInfixString2(left, right, printName, opSymbol) ;
    }

    public String asPrefixString()
    {
        return QueryPrintUtils.asPrefixString(left, right, printName, opSymbol) ;
    }

    public void print(PrintWriter pw, int level)
    {
        QueryPrintUtils.print(pw, left, right, printName, opSymbol, level) ;
    }

    public String toString()
    {
        return asInfixString() ;
    }
}

/*
 *  (c) Copyright Hewlett-Packard Company 2001-2003, 2001-2003
 *  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
