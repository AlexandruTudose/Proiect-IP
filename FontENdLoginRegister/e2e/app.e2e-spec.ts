import { Projeeect1234Page } from './app.po';

describe('projeeect1234 App', function() {
  let page: Projeeect1234Page;

  beforeEach(() => {
    page = new Projeeect1234Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
