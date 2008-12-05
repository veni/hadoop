/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.chukwa.extraction.archive;


import java.text.SimpleDateFormat;

import org.apache.hadoop.chukwa.ChukwaArchiveKey;
import org.apache.hadoop.chukwa.ChunkImpl;
import org.apache.hadoop.mapred.lib.MultipleSequenceFileOutputFormat;
import org.apache.log4j.Logger;

public class ChukwaArchiveDailyOutputFormat extends MultipleSequenceFileOutputFormat<ChukwaArchiveKey, ChunkImpl>
{
	static Logger log = Logger.getLogger(ChukwaArchiveDailyOutputFormat.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
	
	
	@Override
	protected String generateFileNameForKeyValue(ChukwaArchiveKey key, ChunkImpl chunk,
			String name)
	{
		
		if (log.isDebugEnabled())
			{log.debug("ChukwaArchiveOutputFormat.fileName: " + sdf.format(key.getTimePartition()));}
		
		return sdf.format(key.getTimePartition()) + ".arc";
	}
}
