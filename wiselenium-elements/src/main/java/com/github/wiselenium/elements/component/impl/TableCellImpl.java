/**
 * Copyright (c) 2013 Andre Ricardo Schaffer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.wiselenium.elements.component.impl;

import static java.lang.Integer.valueOf;

import com.github.wiselenium.elements.component.TableCell;

/**
 * Implementation of a HTML Table Cell (th or td).
 * 
 * @author Andre Ricardo Schaffer
 * @since 0.3.0
 */
public class TableCellImpl extends ComponentImpl<TableCell> implements TableCell {
	
	@Override
	public int getColSpan() {
		String colspan = this.getAttribute("colspan");
		if (colspan == null) return 1;
		return valueOf(colspan);
	}
	
	@Override
	public int getRowSpan() {
		String rowspan = this.getAttribute("rowspan");
		if (rowspan == null) return 1;
		return valueOf(rowspan);
	}
	
	@Override
	public String getText() {
		return this.getWrappedElement().getText();
	}
	
}
