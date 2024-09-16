export class ErrorUtils {
  /**
   * convert error status to route name of error page
   * @param errorStatus error status
   * @returns route name of error page
   */
  static errorRouteName(errorStatus: string): string {
    switch (String(errorStatus).trim()) {
      case '404':
        return 'error-404'
      default:
        return 'error'
    }
  }
}
