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
package org.impressivecode.depress.common;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.knime.core.data.DataCell;
import org.knime.core.data.DataType;
import org.knime.core.data.collection.CollectionCellFactory;
import org.knime.core.data.date.DateAndTimeCell;
import org.knime.core.data.def.BooleanCell;
import org.knime.core.data.def.DoubleCell;
import org.knime.core.data.def.IntCell;
import org.knime.core.data.def.StringCell;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * 
 * @author Marek Majchrzak, ImpressiveCode
 * 
 */
public class Cells {

    public static DataCell integerOrMissingCell(final Integer value) {
        return value == null ? DataType.getMissingCell() : integerCell(value);
    }

    public static DataCell integerCell(final Integer value) {
        return new IntCell(value);
    }

    public static DataCell integerCell(final boolean b) {
        return integerCell(b ? 1 : 0);
    }

    public static DataCell doubleOrMissingCell(final Double value) {
        return value == null ? DataType.getMissingCell() : new DoubleCell(value);
    }

    public static DataCell stringOrMissingCell(final String value) {
        return value == null ? DataType.getMissingCell() : stringCell(value);
    }

    public static DataCell stringOrMissingCell(final Enum<?> enumValue) {
        return stringOrMissingCell(enumValue == null ? null : enumValue.name());
    }

    public static DataCell stringCell(final String value) {
        return new StringCell(value);
    }

    public static DataCell stringCell(final Enum<?> enumValue) {
        return stringCell(enumValue.name());
    }

    public static DataCell stringListOrMissingCell(final List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return DataType.getMissingCell();
        } else {
            return stringListCell(stringList);
        }
    }

    public static DataCell stringListCell(final Iterable<String> stringList) {
        List<DataCell> coll = Lists.newArrayList(Iterables.transform(stringList, new Function<String, DataCell>() {
            @Override
            public DataCell apply(final String value) {
                return stringCell(value);
            }
        }));
        return CollectionCellFactory.createListCell(coll);
    }
    
    public static DataCell dateListOrMissingCell(final List<Date> dateList) {
    	if (dateList == null || dateList.isEmpty()) {
    		return DataType.getMissingCell();
    	} else {
    		return dateListCell(dateList);
    	}
    }
    
    public static DataCell dateListCell(List<Date> dateList) {
    	List<DataCell> coll = Lists.newArrayList(Iterables.transform(dateList, new Function<Date, DataCell>() {

			@Override
			public DataCell apply(Date date) {
				return dateTimeCell(date);
			}
		}));
        return CollectionCellFactory.createListCell(coll);
    }

    public static DataCell integerListCell(final Iterable<Integer> confidence) {
        List<DataCell> coll = Lists.newArrayList(Iterables.transform(confidence, new Function<Integer, DataCell>() {
            @Override
            public DataCell apply(final Integer value) {
                return integerCell(value);
            }
        }));
        return CollectionCellFactory.createListCell(coll);
    }

    public static DataCell stringSetCell(final Iterable<String> cellSet) {
        Set<DataCell> coll = newHashSet(Iterables.transform(cellSet, new Function<String, DataCell>() {
            @Override
            public DataCell apply(final String value) {
                return stringCell(value);
            }
        }));
        return CollectionCellFactory.createSetCell(coll);
    }
    
    public static DataCell stringSetCellOrMissing(final Set<String> stringList) {
    	 if (stringList == null || stringList.isEmpty()) {
             return DataType.getMissingCell();
         } else {
             return stringSetCell(stringList);
         }
    }

    public static DataCell dateTimeOrMissingCell(final Date value) {
        return value == null ? DataType.getMissingCell() : dateTimeCell(value);
    }

    public static DataCell dateTimeCell(final Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        // FIXME: check if time zone assumption is correct
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        calendar.setTime(date);
        return new DateAndTimeCell(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND), calendar.get(Calendar.MILLISECOND));
    }

    public static DataCell booleanCell(final boolean value) {
        return BooleanCell.get(value);
    }
}
