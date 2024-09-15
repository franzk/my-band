export class ErrorUtils {
  static errorRouteName(errorStatus: string): string {
    switch (String(errorStatus).trim()) {
      case '404':
        return 'error-404'
      default:
        return 'error'
    }
  }
}
