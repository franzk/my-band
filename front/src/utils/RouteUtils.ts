export class RouteUtils {
  /**
   * return first element if value is array otherwise return value
   * @param value value or array
   * @returns first element if value is array otherwise return value
   */
  static firstIfArray<T>(value: T | T[]): T {
    return Array.isArray(value) ? value[0] : value
  }
}
