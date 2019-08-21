package root.root;

public class Range {
	
	public long start;
	public long end;
	public long length;
	
	/**
	 * Validate range.
	 *验证范围。
	 * @return true if the range is valid, otherwise false
	 * 如果范围有效，则为真，否则为假
	 */
	public boolean validate() {
		if (end >= length)
			end = length - 1;
		return (start >= 0) && (end >= 0) && (start <= end) && (length > 0);
	}
}
