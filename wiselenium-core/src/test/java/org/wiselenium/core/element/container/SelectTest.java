package org.wiselenium.core.element.container;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.wiselenium.core.element.container.SelectPage.FIRST_OPTION_TEXT;
import static org.wiselenium.core.element.container.SelectPage.FIRST_OPTION_VALUE;
import static org.wiselenium.core.element.container.SelectPage.SECOND_OPTION_TEXT;
import static org.wiselenium.core.element.container.SelectPage.SECOND_OPTION_VALUE;
import static org.wiselenium.core.element.container.SelectPage.SELECT_CLASS;
import static org.wiselenium.core.element.container.SelectPage.SELECT_TITLE;
import static org.wiselenium.core.element.container.SelectPage.THIRD_OPTION_TEXT;
import static org.wiselenium.core.element.container.SelectPage.THIRD_OPTION_VALUE;
import static org.wiselenium.core.pagefactory.WisePageFactory.initElements;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wiselenium.core.TestBase;
import org.wiselenium.core.element.field.Option;

@SuppressWarnings("javadoc")
public class SelectTest extends TestBase {
	
	SelectPage page;
	
	
	@BeforeMethod
	public void initPage() {
		this.page = initElements(this.driver, SelectPage.class);
		this.page.load();
		this.page.isLoaded();
	}
	
	@Test
	public void shouldAllowChainCallsWithAnd() {
		Select select = this.page.getSelect();
		assertEquals(select, select.and());
	}
	
	@Test
	public void shouldGetAttribute() {
		assertNotNull(this.page.getSelect().getAttribute("id"));
		assertNotNull(this.page.getHiddenSelect().getAttribute("id"));
		assertFalse(this.page.getSelect().getAttribute("id").isEmpty());
	}
	
	@Test
	public void shouldGetCssValue() {
		assertTrue(this.page.getSelect().getCssValue("inexistent").isEmpty());
		assertNotNull(this.page.getHiddenSelect().getCssValue("visibility"));
	}
	
	@Test
	public void shouldGetDisplayCondition() {
		assertTrue(this.page.getSelect().isDisplayed());
		assertFalse(this.page.getHiddenSelect().isDisplayed());
	}
	
	@Test
	public void shouldGetId() {
		assertNotNull(this.page.getSelect().getId());
		assertNotNull(this.page.getHiddenSelect().getId());
	}
	
	@Test
	public void shouldGetOptions() {
		List<Option> options = this.page.getSelect().getOptions();
		assertNotNull(options);
		assertTrue(!options.isEmpty());
	}
	
	@Test
	public void shouldGetSelectedValue() {
		assertEquals(this.page.getSelect().getSelectedValue(), FIRST_OPTION_VALUE);
	}
	
	@Test
	public void shouldGetSelectedVisibleText() {
		assertEquals(this.page.getSelect().getSelectedVisibleText(), FIRST_OPTION_TEXT);
	}
	
	@Test
	public void shouldGetStyleClass() {
		assertEquals(this.page.getSelect().getStyleClass(), SELECT_CLASS);
	}
	
	@Test
	public void shouldGetTitle() {
		assertEquals(this.page.getSelect().getTitle(), SELECT_TITLE);
	}
	
	@SuppressWarnings("null")
	@Test
	public void shouldSelectAndGetSelectedOption() {
		Select select = this.page.getSelect();
		List<Option> options = select.getOptions();
		assertTrue(options != null && !options.isEmpty());
		
		String[] values = { FIRST_OPTION_VALUE, SECOND_OPTION_VALUE, THIRD_OPTION_VALUE };
		String[] texts = { FIRST_OPTION_TEXT, SECOND_OPTION_TEXT, THIRD_OPTION_TEXT };
		
		for (int i = 0; i < options.size(); i++) {
			Option option = options.get(i);
			select.selectOption(option);
			assertTrue(option.isSelected());
			Option selectedOption = select.getSelectedOption();
			assertEquals(selectedOption.getValue(), values[i]);
			assertEquals(selectedOption.getVisibleText(), texts[i]);
		}
	}
	
	@Test
	public void shouldSelectByIndex() {
		Select select = this.page.getSelect();
		assertEquals(select.getSelectedValue(), FIRST_OPTION_VALUE);
		
		select.selectByIndex(1);
		assertEquals(select.getSelectedValue(), SECOND_OPTION_VALUE);
	}
	
	@Test
	public void shouldSelectByValue() {
		Select select = this.page.getSelect();
		assertEquals(select.getSelectedValue(), FIRST_OPTION_VALUE);
		
		select.selectByValue(SECOND_OPTION_VALUE);
		assertEquals(select.getSelectedValue(), SECOND_OPTION_VALUE);
	}
	
	@Test
	public void shouldSelectByVisibleText() {
		Select select = this.page.getSelect();
		assertEquals(select.getSelectedVisibleText(), FIRST_OPTION_TEXT);
		
		select.selectByVisibleText(THIRD_OPTION_TEXT);
		assertEquals(select.getSelectedVisibleText(), THIRD_OPTION_TEXT);
	}
	
}