/*
ImpressiveCode Depress Framework
Copyright (C) 2013  ImpressiveCode contributors

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.impressivecode.depress.mr.checkstyle;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * 
 * @author Tomasz Banach
 * @author �ukasz Waga
 * @author Monika Pruszkowska
 * 
 */
public class CheckStyleEntriesParserTest {

    CheckStyleEntriesParser parser = new CheckStyleEntriesParser();

    @Test
    public void shouldParseEntries() throws ParserConfigurationException, SAXException, IOException {
        List<CheckStyleEntry> results = parser.parseEntries(getClass().getResource("checkstyle-test.xml").getPath());
        assertEntry(results.get(2));
        assertEntry2(results.get(85));
    }

    private void assertEntry(final CheckStyleEntry checkStyleEntry) {
        assertThat(checkStyleEntry.getFileName()).isEqualTo("com.virtusa.gto.locc.FileParser");
        assertThat(checkStyleEntry.getLineNumber()).isEqualTo("40");
        assertThat(checkStyleEntry.getColumnNumber()).isEqualTo("9");
        assertThat(checkStyleEntry.getSeverityType()).isEqualTo("error");
        assertThat(checkStyleEntry.getMessageText()).isEqualTo("Missing a Javadoc comment.");
        assertThat(checkStyleEntry.getSourcePlace()).isEqualTo(
                "com.puppycrawl.tools.checkstyle.checks.javadoc.JavadocVariableCheck");
    }

    private void assertEntry2(final CheckStyleEntry checkStyleEntry) {
        assertThat(checkStyleEntry.getFileName()).isEqualTo("com.virtusa.gto.locc.MetricsPrinter");
        assertThat(checkStyleEntry.getLineNumber()).isEqualTo("33");
        assertThat(checkStyleEntry.getColumnNumber()).isEqualTo("5");
        assertThat(checkStyleEntry.getSeverityType()).isEqualTo("error");
        assertThat(checkStyleEntry.getMessageText()).isEqualTo("Missing a Javadoc comment.");
        assertThat(checkStyleEntry.getSourcePlace()).isEqualTo(
                "com.puppycrawl.tools.checkstyle.checks.javadoc.JavadocVariableCheck");
    }

}
